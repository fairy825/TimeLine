# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2019-11-10 09:16:32
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "message"
#

INSERT INTO `message` VALUES (1,'a','2019-10-27 10:55:53','第一条'),(2,'b','2019-10-29 10:55:53','第二条'),(3,'a','2019-10-30 10:55:53','333'),(4,'d','2019-11-09 10:55:53','44');

#
# Structure for table "message_image"
#

DROP TABLE IF EXISTS `message_image`;
CREATE TABLE `message_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '图片所在的消息id',
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "message_image"
#

INSERT INTO `message_image` VALUES (1,1,NULL),(2,1,NULL),(3,3,NULL);
