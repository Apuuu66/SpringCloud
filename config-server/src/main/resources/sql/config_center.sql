/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : springcloud

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/03/2020 10:50:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_center
-- ----------------------------
DROP TABLE IF EXISTS `config_center`;
CREATE TABLE `config_center`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `value1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'application',
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'dev',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'master',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_center
-- ----------------------------
INSERT INTO `config_center` VALUES (1, 'spring.datasource.username', 'root', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (2, 'spring.datasource.password', '123456', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (3, 'spring.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (4, 'spring.datasource.url', 'jdbc:mysql://mysql.host:3306/springcloud?useUnicode=true&useSSL=false&serverTimezone=UTC', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (5, 'spring.jpa.database-platform', 'org.hibernate.dialect.MySQL8Dialect', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (6, 'spring.jpa.hibernate.ddl-auto', 'update', 'application', 'dev', 'master');
INSERT INTO `config_center` VALUES (7, 'spring.datasource.driver-class-name', 'com.p6spy.engine.spy.P6SpyDriver', 'config-client-p6spy', 'dev', 'master');
INSERT INTO `config_center` VALUES (8, 'spring.datasource.url', 'jdbc:p6spy:mysql://mysql.host:3306/springcloud?useUnicode=true&useSSL=false&serverTimezone=UTC', 'config-client-p6spy', 'dev', 'master');

SET FOREIGN_KEY_CHECKS = 1;
