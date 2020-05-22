-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`
(
    `id`       bigint(20)     NOT NULL AUTO_INCREMENT,
    `type`     varchar(255)   NOT NULL,
    `name`     varchar(255)   NOT NULL,
    `salary`   decimal(19, 2) NOT NULL,
    `city`     varchar(255)   NOT NULL,
    `province` varchar(255)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `address`  varchar(255) DEFAULT NULL,
    `age`      int(11)      DEFAULT NULL,
    `birthday` datetime(6)  DEFAULT NULL,
    `name`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;