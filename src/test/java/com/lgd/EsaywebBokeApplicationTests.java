package com.lgd;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.lgd.pojo.*;
import com.lgd.dao.*;
import com.lgd.service.ProductService;
import com.lgd.util.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootTest
class EsaywebBokeApplicationTests {

    @Autowired
    ReportYearMapper reportYearMapper;
    @Autowired
    CommentDao commentDao;
    @Autowired
    BokeDao bokeDao;
    @Autowired
    ScoreDao scoreDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductService service;
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final static Logger log = Logger.getLogger(String.valueOf(EsaywebBokeApplicationTests.class));

    @Test
    void jdbcTest(){
        Integer integer = jdbcTemplate.queryForObject("SELECT 1 FROM dual", Integer.class);
        System.out.println(integer);
    }

    @Test
    void EasyExcelReadTest(){
        String fileName = "E:\\IDEA\\Easyweb-bokeShop\\demoTest.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new ReadListener<DemoData>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 100;
            /**
             *临时存储
             */
            private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            //解析完后做什么
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info(cachedDataList.size() + "条数据，开始存储数据库！");
                ArrayList<Object[]> objectList = new ArrayList<>();
                for (DemoData demoData : cachedDataList) {
                    Object[] objects = new Object[]{demoData.getString(),demoData.getDate(),demoData.getDoubleData()};
                    objectList.add(objects);
                }
                String isnertSql = "insert into excel_test(string,day,number) values(?,?,?)";
                int[] ints = jdbcTemplate.batchUpdate(isnertSql, objectList);
                int actualValue = ints.length;
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();
    }

    public  List<DemoData> data(){
        List<DemoData> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new DemoData("lalalawuwuwu"+i,new Date(),(double) i+50,null));
        }
        return data;
    }

    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "E:\\IDEA\\Easyweb-bokeShop\\demoTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
/*        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });*/

        // 写法2
        fileName = "E:\\IDEA\\Easyweb-bokeShop\\demoTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

/*        // 写法3
        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        }*/
    }

    @Test
    void ProductServiceTest(){
        int num = service.addToOrder(1,8003,3);
        System.out.println(num);
    }

    @Test
    void orderTest(){
//        List<Order> orders = orderDao.getAllOrder(1,1,5);
//        for (Order order:orders)
//            System.out.println(order);
        int count = orderDao.getCount(1);
        System.out.println(count);
//        List<Order> orders = orderDao.findOrder(1,5,"天",1);
//        for(Order order:orders)
//            System.out.println(order);
    }

    @Test
    void productTest(){
        List<Order> orders = productDao.getOrderByUidPid(1,8003);
        Order product = orders.get(0);
        System.out.println(product);
    }

    @Test
    void MD5Test() throws Exception {
        String pwd="123456";
        String newpwd = MD5Utils.md5Password(pwd);
        System.out.println(newpwd);
        String pwd2="123456";
        String newpwd2 = MD5Utils.md5Password(pwd2);
        System.out.println(newpwd2);
        System.out.println(newpwd.equals(newpwd2));
    }

    @Test
    void getAllScore(){
        List<Score> scores = scoreDao.getAllScores(1,5);
        for (Score score:scores)
            System.out.println(score.getCreate_time());
    }

    @Test
    void TestReport(){
        List<Integer> num = reportYearMapper.reportYearBoke("2021");
        for(int n: num){
            System.out.println(n);
        }
        List<Count> counts = reportYearMapper.reportByYears();
        for(Count n: counts){
            System.out.println(n);
        }
//        Boke boke = reportYearMapper.selectByid(1);
//        System.out.println(boke);
    }

    @Test
    void contextLoads() {
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(10,"hello","2709296991@qq.com","lgd",timeStamp,2,null);
        int num = commentDao.updateComment(comment);
        System.out.println(num);
    }//测试功能完成

    @Test
    void CommentAddTest() {
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(0,"hello","2709296991@qq.com","lgd",timeStamp,2,null);
        int num = commentDao.addComment(comment);
        System.out.println(num);
    }//测试功能完成

//    @Test
//    void BokeUpdateTest(){
//        Timestamp timeStamp = new Timestamp(new Date().getTime());
//        Boke boke = new Boke(3,"11","11",timeStamp,1,null);
//        int num = bokeDao.updateBoke(boke);
//        System.out.println(num);
//    }

    @Test
    void CommentTest(){
        List<Comment> commentListlist = commentDao.getAllComments(0, 5);
        for(Comment s:commentListlist){
            System.out.println(s);
        }
    }

    @Test
    void ScoreTest(){
        Timestamp timeStamp = new Timestamp(new Date().getTime());
//        int num = scoreDao.addScore(new Score(0,2,2,timeStamp,90,null,null));
        int num = scoreDao.delScore(2);
        System.out.println(num);
    }
}
