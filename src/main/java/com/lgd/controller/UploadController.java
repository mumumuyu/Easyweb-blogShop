package com.lgd.controller;

import io.swagger.annotations.Authorization;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@RestController
public class UploadController {

    public void copyFile(String src,String destDir,String fileName) throws IOException {
        FileInputStream in=new FileInputStream(src);
        File fileDir = new File(destDir);
        if(!fileDir.isDirectory()){
            fileDir.mkdirs();
        }
        File file = new File(fileDir,fileName);

        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++){
                out.write(buffer[i]);
            }

        }
        in.close();
        out.close();
    }


//    @PostMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    @PostMapping("/upload")
    public HashMap singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        HashMap hashMap = new HashMap();
        File targetFile=null;
        String url="";
        if (file.isEmpty()) {
            hashMap.put("code",500);
            hashMap.put("msg","文件为空");
        } else {
            String fileName = file.getOriginalFilename();
            //图片访问的URI
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/imgs/";
            //文件临时存储位置
            String path = request.getSession().getServletContext().getRealPath("") + "upload" + File.separator + "imgs";
            //文件后缀
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            //新的文件名
            fileName = System.currentTimeMillis() + "_" + new Random().nextInt(1000) + fileSuffix;
            //先判断文件是否存在
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String fileAdd = sdf.format(new Date());
            //获取文件夹路径
            path = path + File.separator + fileAdd + File.separator;
            File file1 = new File(path);
            //如果文件夹不存在则创建
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdirs();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                String projectPath = System.getProperty("user.dir");
                //文件复制
                String src = path + fileName;
                //根据自己系统的resource 目录所在位置进行自行配置
                String destDir = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "upload" + File.separator + "imgs" + File.separator + fileAdd + File.separator;
                copyFile(src, destDir, fileName);
                url = returnUrl + fileAdd + "/" + fileName;
                hashMap.put("code",0);
                hashMap.put("msg","");
                HashMap h = new HashMap();
                h.put("src",url);
                h.put("title",fileName);
                hashMap.put("data",h);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    @GetMapping(value="/download")
    @RequiresAuthentication
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        try {
            //要下载的图片地址
            String  path = "F:\\IDE\\Easyweb-boke\\src\\main\\resources\\static\\assets\\images\\logo.png";
            String  fileName = "logo.png";
            // path是指想要下载的文件的路径
            File file = new File(path);

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
