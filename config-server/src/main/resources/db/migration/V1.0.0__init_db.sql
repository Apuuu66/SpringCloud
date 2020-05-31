-- ----------------------------
-- Table structure for config_center
-- ----------------------------
DROP TABLE IF EXISTS `config_center`;
CREATE TABLE `config_center`
(
    `id`          int(11)       NOT NULL AUTO_INCREMENT,
    `key`        varchar(255)  NULL DEFAULT NULL,
    `value`      varchar(255)  NULL DEFAULT NULL,
    `application` varchar(255)  NULL DEFAULT 'application',
    `profile`     varchar(255)  NULL DEFAULT 'dev',
    `label`       varchar(255)  NULL DEFAULT 'master',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;