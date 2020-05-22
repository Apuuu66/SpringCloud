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