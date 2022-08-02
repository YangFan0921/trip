/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : localhost:3306
 Source Schema         : trip

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 02/08/2022 23:44:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (2, 'images/banner1.jpg');
INSERT INTO `banner` VALUES (3, 'images/banner2.jpg');
INSERT INTO `banner` VALUES (13, '/360016eb-8757-443d-b977-835417c954ee.jpg');
INSERT INTO `banner` VALUES (14, '/4f6fd10c-5cef-443d-937b-9bd3acbb9e3f.jpg');
INSERT INTO `banner` VALUES (15, '/37966664-dcb5-40dd-830f-be3d1357c3a2.jpg');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '时尚轻灵');
INSERT INTO `category` VALUES (2, '唯美典雅');
INSERT INTO `category` VALUES (3, '经典传承');
INSERT INTO `category` VALUES (4, '纪实文艺');
INSERT INTO `category` VALUES (5, '个性潮流');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `viewCount` int NULL DEFAULT NULL,
  `likeCount` int NULL DEFAULT NULL,
  `created` timestamp(0) NOT NULL DEFAULT current_timestamp(0),
  `categoryId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '没有标题', '阿帆', '无详细介绍你干嘛嘛啊啊一呀一哦哦咿呀哦豁你是谁啊我认识尼玛嗯哼', '/2022/07/30/19423cbb-8fa5-4916-bd5f-94efde4da0f3.jpg', 3, 3, '2022-08-01 01:11:16', 4);
INSERT INTO `product` VALUES (2, '想不到标题', '阿帆', '无详细介绍', '/2022/07/30/9ce66950-60c2-4fd5-802f-9677d70e6e1c.jpg', 12, 4, '2022-08-02 00:29:41', 2);
INSERT INTO `product` VALUES (3, '美女旅拍', '帆先生', '没有介绍', '/2022/07/30/cdf96b34-b6e7-4b69-8a89-1e2ce1182563.jpg', 10, 2, '2022-08-01 01:24:06', 3);
INSERT INTO `product` VALUES (4, '自旅', '小阿帆', '这是自旅', '/2022/07/31/eae1984c-41bd-4a7b-a015-b350f4889211.jpg', 7, 4, '2022-08-01 01:25:25', 1);
INSERT INTO `product` VALUES (8, '配置文件', '小帆帆', '无详细介绍', '/2022/08/01/0f7c47dd-1b0a-407e-b641-f9d6a1cdf1b2.png', 1, 0, '2022-08-01 01:59:06', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
