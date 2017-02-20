/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : mybbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-02-20 15:19:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `date` datetime DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `lable` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `uid` (`uid`),
  KEY `author` (`author`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '这是第一篇帖子。。。。', '11111', '2017-02-08 12:28:30', '1', 'ljc', null);
INSERT INTO `article` VALUES ('2', '这是第二篇帖子。。。。。。。。', '22222222', '2017-02-08 13:28:33', '1', 'ljc', null);
INSERT INTO `article` VALUES ('35', '测试uid。。。。', '<p>1111111</p>', '2017-02-08 18:28:39', '2', 'test', null);
INSERT INTO `article` VALUES ('41', '测试标签。。。', '<p>1111<img src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0b/tootha_thumb.gif\"></p><p><br></p>', '2017-02-09 12:28:42', '1', 'ljc', '测试测试');
INSERT INTO `article` VALUES ('53', '表情表情。。', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/huanglianwx_thumb.gif\"><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif\"><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/cool_thumb.gif\"></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/yx_thumb.gif\"></p><p><br></p>', '2017-02-09 12:28:44', '1', 'ljc', '');
INSERT INTO `article` VALUES ('54', '测试回帖。。。', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/af/kl_thumb.gif\"></p><p><br></p>', '2017-02-10 12:28:56', '10', '卢建成', '111');
INSERT INTO `article` VALUES ('55', '头像头像。。。。', '<p>11111111<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/doge_thumb.gif\"></p><p><br></p>', '2017-02-10 12:28:58', '1', 'ljc', '123');
INSERT INTO `article` VALUES ('57', 'test', '<p>111<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif\"></p><p><br></p>', '2017-02-10 13:23:38', '14', 'test4', '');
INSERT INTO `article` VALUES ('61', '测试分页', '<p>111111111</p>', '2017-02-10 15:24:48', '2', 'test', '');
INSERT INTO `article` VALUES ('62', '1111111', '<p>1111111</p>', '2017-02-10 15:25:43', '2', 'test', '');
INSERT INTO `article` VALUES ('68', '测试测试。。。', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif\"></p><p>1<b>232</b>13<font color=\"#880000\">2</font></p><p><font color=\"#000000\" face=\"微软雅黑\">dwddwqd<font size=\"6\">wqdd</font>wdw wedewdwe</font></p><p><a href=\"http://baidu.com\" target=\"_blank\" style=\"background-color: rgb(255, 255, 255);\">百度一下。。</a></p><p><br></p>', '2017-02-10 17:54:42', '1', 'ljc', '123');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `cuser` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `aid` (`aid`),
  KEY `uid` (`uid`),
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '<p>111111<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif\"></p><p><br></p>', '53', '2', 'test', '2017-02-09 17:09:24');
INSERT INTO `comment` VALUES ('2', '<p>哈哈哈哈哈哈</p>', '53', '2', 'test', '2017-02-09 17:10:33');
INSERT INTO `comment` VALUES ('3', '<p>111111</p>', '54', '10', '卢建成', '2017-02-09 17:11:39');
INSERT INTO `comment` VALUES ('4', '<p>1111111</p>', '53', '10', '卢建成', '2017-02-09 17:12:43');
INSERT INTO `comment` VALUES ('5', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif\"></p><p><br></p>', '54', '3', 'test1', '2017-02-09 17:14:48');
INSERT INTO `comment` VALUES ('6', '<p>112223<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/doge_thumb.gif\"></p><p><br></p>', '54', '1', 'ljc', '2017-02-09 18:32:08');
INSERT INTO `comment` VALUES ('7', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif\"></p><p><br></p>', '55', '1', 'ljc', '2017-02-09 20:34:59');
INSERT INTO `comment` VALUES ('8', '<p>--</p>', '55', '1', 'ljc', '2017-02-09 20:47:57');
INSERT INTO `comment` VALUES ('9', '<p>1111</p>', '55', '2', 'test', '2017-02-10 11:26:04');
INSERT INTO `comment` VALUES ('10', '<p>1111112222</p>', '55', '3', 'test1', '2017-02-10 12:42:30');
INSERT INTO `comment` VALUES ('12', '<p>1111111</p>', '55', '11', 'test2', '2017-02-10 13:06:58');
INSERT INTO `comment` VALUES ('13', '<p>啦啦啦啦啦</p>', '57', '14', 'test4', '2017-02-10 13:23:54');
INSERT INTO `comment` VALUES ('14', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/doge_thumb.gif\"></p><p><br></p>', '57', '1', 'ljc', '2017-02-10 13:24:11');
INSERT INTO `comment` VALUES ('17', '<p>123</p>', '54', '1', 'ljc1', '2017-02-10 17:13:23');
INSERT INTO `comment` VALUES ('18', '<p>123</p>', '53', '1', 'ljc1', '2017-02-10 17:13:50');
INSERT INTO `comment` VALUES ('19', '<p>123</p>', '54', '1', 'ljc', '2017-02-10 17:14:32');
INSERT INTO `comment` VALUES ('20', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/doge_thumb.gif\"></p><p><br></p>', '68', '1', 'ljc', '2017-02-10 17:55:01');
INSERT INTO `comment` VALUES ('21', '<p>1111<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/panda_thumb.gif\"></p><p><br></p>', '68', '1', 'ljc', '2017-02-10 17:55:52');
INSERT INTO `comment` VALUES ('22', '<p>qqq<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/cool_thumb.gif\"></p><p><br></p>', '68', '2', 'test', '2017-02-10 17:56:22');
INSERT INTO `comment` VALUES ('23', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/doge_thumb.gif\"></p><p><br></p>', '68', '10', '卢建成', '2017-02-10 17:58:19');
INSERT INTO `comment` VALUES ('24', '<p>sss</p>', '62', '1', 'ljc', '2017-02-20 14:48:24');
INSERT INTO `comment` VALUES ('25', '<p>wwww</p>', '62', '1', 'ljc', '2017-02-20 14:50:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `headimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ljc', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('2', 'test', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('3', 'test1', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('10', '卢建成', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('11', 'test2', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('12', 'test3', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('14', 'test4', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
INSERT INTO `user` VALUES ('15', '123', '202cb962ac59075b964b07152d234b70', '/resources/imgs/head.png');
SET FOREIGN_KEY_CHECKS=1;
