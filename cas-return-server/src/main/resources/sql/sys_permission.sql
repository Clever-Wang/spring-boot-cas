/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : testshiro

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 07/21/2018 18:56:57 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号,本权限可能是该父编号权限的子权限',
  `parent_ids` varchar(20) DEFAULT NULL COMMENT '父编号列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `resource_type` varchar(20) DEFAULT NULL COMMENT '资源类型，[menu|button]',
  `url` varchar(200) DEFAULT NULL COMMENT '资源路径 如：/userinfo/list',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `available` char(1) DEFAULT '0' COMMENT '是否可用0可用  1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_permission`
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES ('1', '0', '0/', 'userInfo:view', 'menu', 'userInfo/view', '用户管理', '0'), ('2', '1', '0/1', 'userInfo:add', 'button', 'userInfo/add', '用户添加', '0'), ('3', '1', '0/1', 'userInfo:del', 'button', 'userInfo/del', '用户删除', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
