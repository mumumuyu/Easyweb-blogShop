/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : myboke

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 10/04/2022 10:19:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for boke
-- ----------------------------
DROP TABLE IF EXISTS `boke`;
CREATE TABLE `boke`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `c_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `boke_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `cata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boke
-- ----------------------------
INSERT INTO `boke` VALUES (1, '学习Springboot+layui', '<p>关于<b>SpringBoot</b>：</p><p cid=\"n9\" mdtype=\"paragraph\" class=\"md-end-block md-p md-focus\"><span md-inline=\"plain\" class=\"md-plain\">springboot :内嵌tomcat</span></p><ul class=\"ul-list\" cid=\"n10\" mdtype=\"list\" data-mark=\"-\"><li class=\"md-list-item\" cid=\"n11\" mdtype=\"list_item\"><p cid=\"n12\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">配置：yml</span></p></li><li class=\"md-list-item\" cid=\"n13\" mdtype=\"list_item\"><p cid=\"n14\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">自动装配--&gt;简化开发ya</span></p></li><li class=\"md-list-item\" cid=\"n15\" mdtype=\"list_item\"><p cid=\"n16\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">继承数据库druid</span></p></li><li class=\"md-list-item\" cid=\"n17\" mdtype=\"list_item\"><p cid=\"n18\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">分布式开发：Dubbo+zookeeper</span></p></li><li class=\"md-list-item\" cid=\"n19\" mdtype=\"list_item\"><p cid=\"n20\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">swagger：接口文档</span></p></li><li class=\"md-list-item\" cid=\"n21\" mdtype=\"list_item\"><p cid=\"n22\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">SpringSecurity / shiro(拦截器功能,方便)</span></p></li><li class=\"md-list-item\" cid=\"n23\" mdtype=\"list_item\"><p cid=\"n24\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">Linux</span></p></li><li class=\"md-list-item\" cid=\"n25\" mdtype=\"list_item\"><p cid=\"n26\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain md-expand\">SpringCloud :真正涉及到微服务,Restful,Eureka,Ribbon,Feign,HyStrix</span></p><ul class=\"ul-list\" cid=\"n27\" mdtype=\"list\" data-mark=\"-\"><li class=\"md-list-item\" cid=\"n28\" mdtype=\"list_item\"><p cid=\"n29\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain\">SpringCloud:config : git 上远程操作</span></p></li></ul><p cid=\"n30\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain\">JVM:常见内容知道就好</span></p></li></ul>', '2020-11-25 19:29:57', 1);
INSERT INTO `boke` VALUES (2, '玩游戏', '<img src=\"http://localhost:8081/upload/imgs/20211115/1636966196554_241.png\" alt=\"1636966196554_241.png\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/48.gif\" alt=\"[伤心]\">人和程序，总得有个能跑', '2021-11-15 16:49:59', 2);
INSERT INTO `boke` VALUES (8, '水标题💧', '<b>水呀水</b>', '2021-12-01 17:34:21', 2);
INSERT INTO `boke` VALUES (10, 'MVC', '<p cid=\"n17\" mdtype=\"paragraph\" class=\"md-end-block md-p md-focus\"><span md-inline=\"plain\" class=\"md-plain\">常见mvc后端框架有：Struts,Spring MVC , ASP.NET MVC,Zend FrameWork,JSF</span></p><p cid=\"n18\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain\">前端MVC：Vue,angularjs,React,backbone</span></p><p cid=\"n19\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain md-expand\">其他模式：MVP,MVV.</span></p>', '2021-12-02 14:53:49', 1);
INSERT INTO `boke` VALUES (11, '真倒霉', '<p>一觉醒来车被砸了<img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/12.gif\" alt=\"[泪]\"></p>', '2021-12-03 08:19:38', 2);
INSERT INTO `boke` VALUES (12, '去修车', '<p>上完课了去修车<img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/15.gif\" alt=\"[生病]\"></p>', '2021-12-03 08:20:11', 3);
INSERT INTO `boke` VALUES (13, '茶百道波霸奶茶真的绝绝子！', '<p><span>去冰五分糖加芋圆椰果！太绝了！有古早奶茶的感觉<img src=\"http://localhost:8081/upload/imgs/20211208/1638931532784_716.png\" alt=\"1638931532784_716.png\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/28.gif\" alt=\"[馋嘴]\"></span></p>', '2021-12-08 10:45:51', 5);
INSERT INTO `boke` VALUES (14, '风靡朋友圈的网红小蛋糕，颜值高味道好', '<p><span>我真是超爱草莓季呀，红彤彤的草莓，用来搭配甜点实在是太美啦，而且还解腻。<img src=\"http://localhost:8081/assets/libs/layui/images/face/37.gif\" alt=\"[色]\"><img src=\"http://localhost:8081/upload/imgs/20211208/1638931759430_299.png\" alt=\"1638931759430_299.png\"></span></p>', '2021-12-08 10:49:41', 5);
INSERT INTO `boke` VALUES (15, '西湖美景，芜~', '<p><span>湖水无言，静默的像一帛绿色的软锦，在风里抖动着她的柔婉。西湖，就这样以她的柔美温婉的靓姿倩影，静静地迎来无数个春秋，又送走多少回春夏。<img src=\"http://localhost:8081/assets/libs/layui/images/face/39.gif\" alt=\"[鼓掌]\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/13.gif\" alt=\"[偷笑]\"><img src=\"http://localhost:8081/upload/imgs/20211208/1638931902518_968.png\" alt=\"1638931902518_968.png\"></span></p>', '2021-12-08 10:52:15', 7);
INSERT INTO `boke` VALUES (16, 's11 云顶阵容分享——宝宝狙', '<p><span>这是个7人口可以玩到死的阵容，3星女枪能有烂分，8级有很多路线，无转职最好是单补塔里克出3白魔1名流，聚光灯位置刷在角落就让2个狙神吃，刷的不好就让奥利安娜吃，假如有狙神或者发条的海克斯或者转职书8人口补4狙加伤害或者4发条加攻速</span></p><p>7人口成员：烬、厄运小姐、奥利安娜、迦娜、利桑卓、布隆、布里茨</p><p>7人口羁绊：2狙神2精密发条2学者2保镖2/3白魔法0/1社会名流0/1猫猫</p>', '2021-12-08 10:58:14', 6);

-- ----------------------------
-- Table structure for cata
-- ----------------------------
DROP TABLE IF EXISTS `cata`;
CREATE TABLE `cata`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cata
-- ----------------------------
INSERT INTO `cata` VALUES (1, '技术记录', '2021-11-06 22:08:18');
INSERT INTO `cata` VALUES (2, '生活分享', '2021-11-06 22:08:27');
INSERT INTO `cata` VALUES (3, '日常规划', '2021-11-06 22:08:43');
INSERT INTO `cata` VALUES (5, '美食分享', '2021-12-08 10:34:14');
INSERT INTO `cata` VALUES (6, '游戏攻略', '2021-12-08 10:34:23');
INSERT INTO `cata` VALUES (7, '旅游摄影', '2021-12-08 10:34:44');
INSERT INTO `cata` VALUES (8, '穿搭分享', '2021-12-08 10:38:42');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nick` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `b_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `b_id`(`b_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `boke` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'hello', '2709296991@qq.com', 'lgd', '2021-11-11 16:30:56', 1);
INSERT INTO `comment` VALUES (2, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (3, '测试下', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 2);
INSERT INTO `comment` VALUES (4, '好好学习', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (5, '学javaweb', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (6, '学mysql', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (7, '学layui', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (8, '学mybatis', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (9, '学spring', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (10, 'hello', '2709296991@qq.com', 'lgd', '2022-02-09 16:22:41', 2);
INSERT INTO `comment` VALUES (11, '学springBoot', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (12, '学SpringCloud', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (13, 'hello', '2709296991@qq.com', 'lgd', '2021-11-14 11:16:45', 2);
INSERT INTO `comment` VALUES (19, 'hello', '2709296991@qq.com', 'lgd', '2022-02-03 15:28:12', 2);
INSERT INTO `comment` VALUES (20, 'hello', '2709296991@qq.com', 'lgd', '2022-02-03 15:31:50', 2);
INSERT INTO `comment` VALUES (21, 'hello', '2709296991@qq.com', 'lgd', '2022-02-09 16:22:41', 2);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(0) NOT NULL,
  `u_id` bigint(0) NOT NULL,
  `p_id` int(0) NOT NULL,
  `amount` int(0) NULL DEFAULT NULL,
  `money` float(10, 2) NULL DEFAULT NULL,
  `payment_status` int(0) NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`, `p_id`) USING BTREE,
  INDEX `p_id_fk`(`p_id`) USING BTREE,
  CONSTRAINT `p_id_fk` FOREIGN KEY (`p_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id_ofk` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (14, 1, 8001, 5, 970.00, 0, 0, '2022-01-03 07:48:59');
INSERT INTO `order` VALUES (3, 1, 8002, 5, 3297.00, 1, 1, '2021-12-03 21:16:16');
INSERT INTO `order` VALUES (15, 1, 8003, 9, 900.00, 0, 0, '2022-02-03 15:28:12');
INSERT INTO `order` VALUES (6, 1, 8009, 2, 50.00, 0, 0, '2021-12-08 13:59:13');
INSERT INTO `order` VALUES (8, 1, 8022, 2, 79.80, 0, 0, '2021-12-08 13:59:20');
INSERT INTO `order` VALUES (9, 1, 8024, 2, 5198.00, 0, 0, '2021-12-08 13:59:21');
INSERT INTO `order` VALUES (10, 1, 8027, 2, 176.00, 0, 0, '2021-12-08 13:59:24');
INSERT INTO `order` VALUES (11, 1, 8030, 2, 459.60, 0, 0, '2021-12-08 13:59:33');
INSERT INTO `order` VALUES (12, 1, 8033, 2, 276.00, 0, 0, '2021-12-08 13:59:36');
INSERT INTO `order` VALUES (13, 1, 8034, 2, 2798.00, 0, 0, '2021-12-08 13:59:39');
INSERT INTO `order` VALUES (2, 2, 8001, 1, 194.00, 1, 1, '2021-12-03 10:16:16');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `stock` int(0) NULL DEFAULT NULL,
  `img_url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (8001, '天猫魔盒', '盒', 194.00, 499981, '<a href=\"https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.21.30337dabkY6Q37&id=629588158046\" title=\"点我查看详细\"><img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/tmmh.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8002, '明星同款太阳镜', '副', 899.00, 43, '<a href=\"https://detail.tmall.com/item.htm?id=643272943855\" title=\"点我查看详细\"><img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/mxtktyj.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8003, 'tp-link路由器', '个', 100.00, 60, '<a href=\"https://detail.tmall.com/item.htm?id=586835272611&sku_properties=5919063:3284564\"title=\"点我查看详细\"> <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/tplink.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8004, '云南白药牙膏', '只', 10.00, 66, '<a href=\"https://item.taobao.com/item.htm?id=662314029146\" title=\"点我查看详细\"><img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/ynbyyg.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8005, '康师傅红烧牛肉面', '桶', 5.00, 68, '<a href=\"https://chaoshi.detail.tmall.com/item.htm?id=605687714933\" title=\"点我查看详细\"><img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/ksfhsnrm.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8006, '小米音箱', '个', 200.00, 90, '<a href=\"https://detail.tmall.com/item.htm?id=657902734446&sku_properties=5919063:6536025\" title=\"点我查看详细\"<img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/xiaomiaiyx.png\"></a>', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8007, '植护抽纸', '包', 30.00, 6000, '<img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/zhihu.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8008, '鼠标垫', '个', 5.00, 5000, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/sbd.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8009, '全自动雨伞', '柄', 25.00, 70, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/yusan.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8010, '原道耳机', '对', 10.00, 800, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/erji.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8011, '慢严舒柠清喉利咽颗粒', '盒', 32.00, 40, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/yao.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8012, '羽毛球拍', '个', 130.00, 30, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/yumao.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8013, '回力球鞋', '双', 79.00, 55, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/huili.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8014, '乐事薯片', '包', 19.90, 103, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/leshi.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8015, '台灯', '盏', 29.90, 40, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/deng.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8016, '保温杯', '个', 25.80, 37, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/bei.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8017, 'MP3', '个', 79.00, 60, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/MP3.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8018, '医用口罩', '包', 19.50, 70, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/kouzhao.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8019, '999感冒灵', '包', 41.90, 30, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/999.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8020, '羽绒服', '件', 188.00, 30, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/yurong.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8021, '冬季外套女', '件', 68.00, 50, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/dongnv.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8022, '床帘', '套', 39.90, 56, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/chuanglian.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8023, '垃圾袋', '卷', 6.50, 22, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/laji.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8024, '扫地机器人', '个', 2599.00, 13, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/saodi.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8025, '小型电风扇', '个', 25.90, 28, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/fengshan.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8026, '初音未来fufu', '个', 85.00, 64, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/weilai.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8027, '充电宝', '个', 88.00, 64, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/cdb.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8028, '商务手提包', '件', 298.00, 40, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/stb.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8029, '固态硬盘', '个', 288.00, 20, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/yingpan.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8030, '家用真空机', '台', 229.80, 20, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/zkj.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8031, '儿童座椅', '把', 538.00, 10, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/ertong.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8032, '动漫卡套', '个', 3.60, 760, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/katao.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8033, '三国杀桌游卡牌', '盒', 138.00, 43, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/sgs.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8034, '乐高积木', '盒', 1399.00, 8, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/legao.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 0);
INSERT INTO `product` VALUES (8035, '晨光中性笔芯', '盒', 6.50, 800, ' <img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/bixin.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);
INSERT INTO `product` VALUES (8036, '绿萝盆栽植物', '盆', 32.00, 74, '<img src=\"http://bucket-hangzhou-lgd.oss-cn-hangzhou.aliyuncs.com/blogShop/product/zhiwu.png\">', '好东西', '2021-12-04 09:27:17', '2021-12-04 09:58:44', 1);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(0) NOT NULL,
  `u_id` bigint(0) NOT NULL,
  `b_id` int(0) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`, `b_id`) USING BTREE,
  INDEX `b_id_fk`(`b_id`) USING BTREE,
  CONSTRAINT `b_id_fk` FOREIGN KEY (`b_id`) REFERENCES `boke` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id_fk` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (6, 1, 1, '2021-12-05 18:50:03', 70);
INSERT INTO `score` VALUES (3, 1, 8, '2021-11-23 10:44:36', 80);
INSERT INTO `score` VALUES (9, 1, 11, NULL, 50);
INSERT INTO `score` VALUES (8, 1, 14, '2022-01-03 07:50:30', 60);
INSERT INTO `score` VALUES (4, 2, 1, '2021-11-23 10:45:17', 80);
INSERT INTO `score` VALUES (5, 2, 10, '2021-11-23 10:45:06', 90);
INSERT INTO `score` VALUES (7, 22, 12, '2021-12-03 18:20:31', 90);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户编码',
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `gender` int(0) NULL DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'lgd', 'e10adc3949ba59abbe56e057f20f883e', 1, '13586684997', '杭州市西湖区留和路', 'admin', 'view,edit');
INSERT INTO `user` VALUES (2, 'liming', '李明', 'e10adc3949ba59abbe56e057f20f883e', 1, '13688884457', '北京市东城区前门东大街9号', 'user', 'view');
INSERT INTO `user` VALUES (22, 'ceshi', '测试用户', 'e10adc3949ba59abbe56e057f20f883e', 2, '13777777777', 'HZ', 'user', 'view');

SET FOREIGN_KEY_CHECKS = 1;
