/*
 Navicat MySQL Data Transfer

 Source Server         : 
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : order_system

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/06/2019 20:51:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户名',
  `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员姓名',
  `admin_sex` int(2) NOT NULL COMMENT '管理员性别:1为男，0为女',
  `admin_idnum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员身份证号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'huengceng', 'huengceng', '张三', 0, '1234');
INSERT INTO `administrator` VALUES (2, '13034296788', '000000', '李四', 1, '2345678');

-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `isShow` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES (1, '系统管理员', 1);
INSERT INTO `depart` VALUES (2, '屌丝公司', 1);
INSERT INTO `depart` VALUES (4, '普通部门', 1);
INSERT INTO `depart` VALUES (5, '微软', 1);
INSERT INTO `depart` VALUES (6, '谷歌', 1);
INSERT INTO `depart` VALUES (7, 'IBM', 1);
INSERT INTO `depart` VALUES (8, 'Depin', 1);
INSERT INTO `depart` VALUES (9, 'HuaWei', 1);
INSERT INTO `depart` VALUES (10, '阿里', 1);
INSERT INTO `depart` VALUES (11, '腾讯', 1);
INSERT INTO `depart` VALUES (20, '字节跳动', 1);
INSERT INTO `depart` VALUES (25, '网易', 1);
INSERT INTO `depart` VALUES (26, '个体', 0);

-- ----------------------------
-- Table structure for dining
-- ----------------------------
DROP TABLE IF EXISTS `dining`;
CREATE TABLE `dining`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单单号',
  `personnel_id` int(5) NOT NULL COMMENT '订餐人id',
  `dinner_number` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '就餐人数',
  `order_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单日期',
  `dinner_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '就餐日期',
  `dinner_time` int(2) NULL DEFAULT NULL COMMENT '就餐段',
  `dinner_way` int(2) NULL DEFAULT NULL COMMENT '就餐方式',
  `dinner_instructions` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订餐说明',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_number`(`order_number`) USING BTREE,
  INDEX `personnel_id`(`personnel_id`) USING BTREE,
  CONSTRAINT `dining_ibfk_1` FOREIGN KEY (`personnel_id`) REFERENCES `personnel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '就餐表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dining
-- ----------------------------
INSERT INTO `dining` VALUES (1, '20190508-1', 2, '32', '2019-05-08', '2019-05-31', 1, 0, '少辣');
INSERT INTO `dining` VALUES (4, '20190509-1', 17, '43', '2019-05-09', '2019-05-14', 2, 0, '多辣');
INSERT INTO `dining` VALUES (5, '20190509-2', 18, '54', '2019-05-09', '2019-05-21', 1, 0, '不要辣');
INSERT INTO `dining` VALUES (6, '20190509-3', 19, '98', '2019-05-09', '2019-05-20', 2, 0, '主食是馒头');
INSERT INTO `dining` VALUES (7, '20190509-4', 20, '87', '2019-05-09', '2019-05-10', 2, 0, '要吃米饭');
INSERT INTO `dining` VALUES (8, '20190510-1', 20, '3', '2019-05-10', '2019-06-01', 2, 1, '喝酒');

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `personnel_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订餐人姓名',
  `personnel_sex` int(2) NULL DEFAULT NULL COMMENT '订餐人性别',
  `personnel_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订餐人电话',
  `personnel_idnum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订餐人身份证号',
  `depart_id` int(5) NULL DEFAULT NULL COMMENT '外键：所属部门',
  `restaurant_id` int(5) NULL DEFAULT NULL COMMENT '外键：订餐餐厅',
  `personnel_date` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `depart_id`(`depart_id`) USING BTREE,
  INDEX `restaurant_id`(`restaurant_id`) USING BTREE,
  CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `depart` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `personnel_ibfk_2` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES (1, '张三', 1, '17863606234', '341221199702197681', 2, 1, '2019-05-01');
INSERT INTO `personnel` VALUES (2, '李四', 1, '17863636234', '341221199202197681', 2, 1, '2019-02-01');
INSERT INTO `personnel` VALUES (3, '张晓庆', 1, '17863306234', '341221199752197681', 2, 1, '2019-05-02');
INSERT INTO `personnel` VALUES (4, '张庆', 1, '17863301234', '341221199752197981', 2, 1, '2009-05-02');
INSERT INTO `personnel` VALUES (5, '张晓', 1, '17863316234', '341221199752197681', 2, 1, '2019-01-02');
INSERT INTO `personnel` VALUES (6, '王五', 0, '17863312234', '341291199752197681', 2, 1, '2010-01-02');
INSERT INTO `personnel` VALUES (7, '张军', 0, '17863311234', '341291109752197681', 2, 1, '2000-01-02');
INSERT INTO `personnel` VALUES (8, '刘塞斯', 0, '17863911234', '341291107752197681', 2, 1, '2012-01-02');
INSERT INTO `personnel` VALUES (9, '刘斯', 1, '17863211234', '341291197752197681', 2, 1, '2012-12-02');
INSERT INTO `personnel` VALUES (10, '刘二', 0, '17863293234', '341291197707597681', 2, 1, '2013-12-02');
INSERT INTO `personnel` VALUES (11, '刘三', 1, '17863223234', '341293397707597681', 2, 1, '2014-12-02');
INSERT INTO `personnel` VALUES (12, '张三', 1, '17863606234', '341221199702197681', 2, 2, '2019-11-01');
INSERT INTO `personnel` VALUES (13, '李四', 1, '17863636234', '341221199202197681', 2, 3, '2019-05-08');
INSERT INTO `personnel` VALUES (17, '六一', 1, '17863606813', NULL, 26, 4, '2019-05-09');
INSERT INTO `personnel` VALUES (18, '张晓庆', 1, '17863306234', '341221199752197681', 2, 1, '2019-05-09');
INSERT INTO `personnel` VALUES (19, '六一', 1, '17863606813', NULL, 26, 5, '2019-05-09');
INSERT INTO `personnel` VALUES (20, '欣小萌', 3, '17863676912', NULL, 26, 5, '2019-05-09');
INSERT INTO `personnel` VALUES (21, '二三', 0, '13034596799', '9876543', 2, 2, '2019-05-11');

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `restaurant_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '餐厅名',
  `restaurant_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '餐厅地址',
  `restaurant_manager` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '餐厅负责人',
  `restaurant_managerphone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '餐厅负责人电话',
  `is_show` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '餐厅表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
INSERT INTO `restaurant` VALUES (1, '西餐厅', '留学生公寓旁', '王五', '17863606817', 1);
INSERT INTO `restaurant` VALUES (2, '东餐厅', '46号楼北', '刘赛赛', '17863606813', 1);
INSERT INTO `restaurant` VALUES (3, '百雅餐厅', '东门附近', '李四', '17863689876', 1);
INSERT INTO `restaurant` VALUES (4, '老西餐厅', '西门', '张晓', '17856435907', 1);
INSERT INTO `restaurant` VALUES (5, '蓝工', '软件', '胡', '14567893456', 1);
INSERT INTO `restaurant` VALUES (6, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (7, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (8, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (9, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (10, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (11, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (12, '', '', '', '17863606817', 0);
INSERT INTO `restaurant` VALUES (13, '', '', '', 'search', 0);

-- ----------------------------
-- Table structure for sql_backup
-- ----------------------------
DROP TABLE IF EXISTS `sql_backup`;
CREATE TABLE `sql_backup`  (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `backup_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据库备份日期',
  `backup_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作人',
  `backup_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备份路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sql_backup
-- ----------------------------
INSERT INTO `sql_backup` VALUES (1, '2019-05-12', '张三', 'F:\\Code\\JavaStudy2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\OrderSystem\\backup/2019-05-12.sql');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('a', 1);
INSERT INTO `test` VALUES ('b', 2);
INSERT INTO `test` VALUES ('d', 3);
INSERT INTO `test` VALUES ('e', 4);

SET FOREIGN_KEY_CHECKS = 1;
