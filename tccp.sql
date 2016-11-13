/*
Navicat MySQL Data Transfer

Source Server         : localhost：3306
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : tccp

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-09-07 15:45:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` char(8) NOT NULL,
  `username` char(10) NOT NULL DEFAULT 'tcer',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('04131001', 'test1');
INSERT INTO `test` VALUES ('04131002', 'test1');
INSERT INTO `test` VALUES ('04131003', 'test1');
INSERT INTO `test` VALUES ('04131066', 'test');
INSERT INTO `test` VALUES ('04131068', 'test');
