/*
Navicat MySQL Data Transfer

Source Server         : MYSQL-127.0.0.1
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : springlesson

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-01-12 22:50:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `pub_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'SpringMVC Lesson', 'SpringMVC Lesson', '2', '2018-01-12');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Steve', 'happy', 'Steve', 'NoJob');
INSERT INTO `user` VALUES ('2', 'Bill', 'birthday', 'Bill', 'Gates');
INSERT INTO `user` VALUES ('3', 'Mark', 'to', 'Mark', 'Zuckerberg');
INSERT INTO `user` VALUES ('4', 'gauss', 'you', 'Gaussic', 'Star');
