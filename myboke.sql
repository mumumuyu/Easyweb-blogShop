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

 Date: 20/11/2021 10:14:15
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boke
-- ----------------------------
INSERT INTO `boke` VALUES (1, '学习Springboot+layui', '<p>关于<b>SpringBoot</b>：</p><p cid=\"n9\" mdtype=\"paragraph\" class=\"md-end-block md-p md-focus\"><span md-inline=\"plain\" class=\"md-plain\">springboot :内嵌tomcat</span></p><ul class=\"ul-list\" cid=\"n10\" mdtype=\"list\" data-mark=\"-\"><li class=\"md-list-item\" cid=\"n11\" mdtype=\"list_item\"><p cid=\"n12\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">配置：yml</span></p></li><li class=\"md-list-item\" cid=\"n13\" mdtype=\"list_item\"><p cid=\"n14\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">自动装配--&gt;简化开发</span></p></li><li class=\"md-list-item\" cid=\"n15\" mdtype=\"list_item\"><p cid=\"n16\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">继承数据库druid</span></p></li><li class=\"md-list-item\" cid=\"n17\" mdtype=\"list_item\"><p cid=\"n18\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">分布式开发：Dubbo+zookeeper</span></p></li><li class=\"md-list-item\" cid=\"n19\" mdtype=\"list_item\"><p cid=\"n20\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">swagger：接口文档</span></p></li><li class=\"md-list-item\" cid=\"n21\" mdtype=\"list_item\"><p cid=\"n22\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">SpringSecurity / shiro(拦截器功能,方便)</span></p></li><li class=\"md-list-item\" cid=\"n23\" mdtype=\"list_item\"><p cid=\"n24\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain\">Linux</span></p></li><li class=\"md-list-item\" cid=\"n25\" mdtype=\"list_item\"><p cid=\"n26\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"tab\" class=\"md-tab\">	</span><span md-inline=\"plain\" class=\"md-plain md-expand\">SpringCloud :真正涉及到微服务,Restful,Eureka,Ribbon,Feign,HyStrix</span></p><ul class=\"ul-list\" cid=\"n27\" mdtype=\"list\" data-mark=\"-\"><li class=\"md-list-item\" cid=\"n28\" mdtype=\"list_item\"><p cid=\"n29\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain\">SpringCloud:config : git 上远程操作</span></p></li></ul><p cid=\"n30\" mdtype=\"paragraph\" class=\"md-end-block md-p\"><span md-inline=\"plain\" class=\"md-plain\">JVM:常见内容知道就好</span></p></li></ul>', '2020-11-19 22:26:06', 1);
INSERT INTO `boke` VALUES (2, '学个屁，玩游戏', '<img src=\"http://localhost:8081/upload/imgs/20211115/1636966196554_241.png\" alt=\"1636966196554_241.png\"><img src=\"http://localhost:8081/assets/libs/layui/images/face/48.gif\" alt=\"[伤心]\">人和程序，总得有个能跑', '2021-11-15 16:49:59', 2);
INSERT INTO `boke` VALUES (8, '水标题💧', '<b>水呀水</b>', '2021-11-17 17:34:21', 2);

-- ----------------------------
-- Table structure for cata
-- ----------------------------
DROP TABLE IF EXISTS `cata`;
CREATE TABLE `cata`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cata
-- ----------------------------
INSERT INTO `cata` VALUES (1, '技术记录', '2021-11-06 22:08:18');
INSERT INTO `cata` VALUES (2, '生活分享', '2021-11-06 22:08:27');
INSERT INTO `cata` VALUES (3, '日常规划', '2021-11-06 22:08:43');

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'hello', '2709296991@qq.com', 'lgd', '2021-11-11 16:30:56', 1);
INSERT INTO `comment` VALUES (2, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (3, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 2);
INSERT INTO `comment` VALUES (4, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (5, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (6, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (7, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (8, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (9, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (10, 'hello', '2709296991@qq.com', 'lgd', '2021-11-14 11:23:16', 2);
INSERT INTO `comment` VALUES (11, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (12, '学', '2709296991@qq.com', 'lgd', '2021-11-11 16:31:56', 1);
INSERT INTO `comment` VALUES (13, 'hello', '2709296991@qq.com', 'lgd', '2021-11-14 11:16:45', 2);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(0) NOT NULL,
  `b_id` int(0) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `score` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `u_id`, `b_id`) USING BTREE,
  INDEX `b_id_fk`(`b_id`) USING BTREE,
  INDEX `u_id_fk`(`u_id`) USING BTREE,
  CONSTRAINT `b_id_fk` FOREIGN KEY (`b_id`) REFERENCES `boke` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id_fk` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 1, '2021-11-17 17:33:52', 70);
INSERT INTO `score` VALUES (2, 2, 1, '2021-11-16 11:49:43', 75);
INSERT INTO `score` VALUES (3, 1, 2, '2021-11-17 11:49:43', 80);
INSERT INTO `score` VALUES (4, 2, 2, '2021-11-17 11:49:43', 95);
INSERT INTO `score` VALUES (6, 1, 8, '2021-11-17 17:47:44', 80);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户编码',
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `gender` int(0) NULL DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'lgd', '123456', 2, '13586684997', '杭州市西湖区留和路', 'admin', 'view,edit');
INSERT INTO `user` VALUES (2, 'liming', '李明', '123456', 1, '13688884457', '北京市东城区前门东大街9号', 'user', 'view');

SET FOREIGN_KEY_CHECKS = 1;
