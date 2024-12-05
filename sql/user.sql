/*
 Navicat Premium Data Transfer

 Source Server         : mysq
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : xnkd

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 05/12/2024 09:17:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint NULL DEFAULT 1 COMMENT '0表示女，1表示男',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'kkk', 18, NULL, NULL, 1, NULL, NULL, NULL, NULL, 1);
INSERT INTO `user` VALUES (3, 'kkk', 18, NULL, NULL, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (4, '忻奕泽', 41, NULL, 'mg0iuc12@foxmail.com', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (5, '弭静', 86, '8EYHVo7jeW', 'm8eiuk_nevn5747@tom.com', 1, '4Ey27UBS9J', 'iMApqz7Smn', NULL, NULL, 0);
INSERT INTO `user` VALUES (6, '莫子韬', 11, 'qEAIuTQ4JM', 'mz615@gmail.com', 1, '7fGzyYOmTQ', 'yQqYUVd63D', NULL, NULL, 0);
INSERT INTO `user` VALUES (7, '范云熙', 72, 'jhdYr32d1v', 'fan5@icloud.com', 1, 'SFxNBoPDeV', 'PtOY80mrzu', NULL, NULL, 0);
INSERT INTO `user` VALUES (8, '薛晓明', 56, 'FNWpPQnXXr', 'xuxia6@outlook.com', 1, 'zIUMaee77k', 'kqE3kG5rwq', NULL, NULL, 0);
INSERT INTO `user` VALUES (9, '莫安琪', 33, '3G2I3BLdOU', 'anqim5@icloud.com', 0, 'Io5CZHhuYu', 'O8pGLWUETn', NULL, NULL, 0);
INSERT INTO `user` VALUES (10, '于宇宁', 38, 'nlwH1JBZyP', 'yuniyu5@yahoo.com', 0, 'zu1e3l400B', 'w5rTY4aHpa', NULL, NULL, 1);
INSERT INTO `user` VALUES (11, '陆帅', 2, 'Ml2Iw2ZHB9', 'ppm66@yeah.net', 1, 'dBrA61Mrrf', 'e4aPNLPKog', NULL, NULL, 0);
INSERT INTO `user` VALUES (12, '彭致远', 35, 'tWZmzp7k8C', 'peng6@mail.com', 1, 'd78pe8Tczs', 'eiSqYVOr0X', NULL, NULL, 0);
INSERT INTO `user` VALUES (13, '莫秀英', 95, 'oAtHLmImBy', 'mo5@icloud.com', 0, 'L2az0rrVYz', 'DJfoAdG60d', NULL, NULL, 0);
INSERT INTO `user` VALUES (14, '何安琪', 94, '3XH8vq7OVf', 'anqihe@hotmail.com', 0, 'a55ZrVHUHN', 'wv4COPN18A', NULL, NULL, 0);
INSERT INTO `user` VALUES (15, '石云熙', 44, 'KjIPfq2Mll', 'syunxi@hotmail.com', 1, 'w2y1teuai5', 'bnbaCF0MFv', NULL, NULL, 0);
INSERT INTO `user` VALUES (16, '贾子韬', 21, 'roGEuoEeA9', 'zitaojia@mail.com', 1, 'cQi9uh2uh0', 's7l9gD2FT8', NULL, NULL, 0);
INSERT INTO `user` VALUES (17, '赵安琪', 79, '6lYFpvgO9w', 'zha@hotmail.com', 0, 'muax4zLEbf', 'nwZu8eIOPb', NULL, NULL, 0);
INSERT INTO `user` VALUES (18, '孟詩涵', 86, 'IuKFPHh70Z', 'shihan1024@icloud.com', 1, '5028FqxzCo', 'coSvSkDVYo', NULL, NULL, 0);
INSERT INTO `user` VALUES (19, '孟宇宁', 39, 'deOIQXsXNy', 'yuningmen@outlook.com', 1, 'm95M4KZqGh', 'nYavUZ2fWt', NULL, NULL, 0);
INSERT INTO `user` VALUES (20, '朱晓明', 13, 'JoN6O7TOYX', 'xzhu3@hotmail.com', 0, 'LFRf3DRaRg', '7Mo5ELDKDx', NULL, NULL, 0);
INSERT INTO `user` VALUES (21, '武晓明', 82, 'vRxn94wx08', 'wux@yahoo.com', 0, 'JKz3ZGl34R', 'rJ3qz1INex', NULL, NULL, 0);
INSERT INTO `user` VALUES (22, '理超栋', 13, '75WzZBYJnu', 'fmnrmi5@qq.com', 1, 'XYri3bBcSJ', 'O9VNmQimiI', NULL, NULL, 0);
INSERT INTO `user` VALUES (23, '贺宇宁', 95, 'sY8v1CPn6u', 'heyuni@yahoo.com', 1, 'aog7mK3GjU', '7LXTY6O6ht', NULL, NULL, 0);
INSERT INTO `user` VALUES (24, '萧晓明', 48, 'Dfu43o4B6k', 'xixiaoming2009@icloud.com', 0, 'je7bjpcUOJ', '5nJcbKRdVv', NULL, NULL, 0);
INSERT INTO `user` VALUES (25, '莫璐', 5, 'WjZjefrRPo', 'lumo@hotmail.com', 1, 'FMQbmr5cMC', 'D5jiCBMzoz', NULL, NULL, 0);
INSERT INTO `user` VALUES (26, '谭子韬', 73, '217u6GnYTb', 'tanzitao8@gmail.com', 0, 'rYwRtp3nnm', 'LcZcSgZs2Y', NULL, NULL, 0);
INSERT INTO `user` VALUES (27, '梅国香', 24, '$1$WD79at$qiiudLFs4yUVV60oFhwp9/', '123@qq.com', 1, NULL, '$1$WD79at', NULL, NULL, 0);
INSERT INTO `user` VALUES (28, '太叔俊杰', 21, '$1$0iu8xN$5sL9dNjG5cnHO0lqHQUQS.', 'mzitue78@foxmail.com', 1, NULL, '$1$0iu8xN', '2024-12-04 16:06:05', '2024-12-04 16:06:05', 0);

SET FOREIGN_KEY_CHECKS = 1;
