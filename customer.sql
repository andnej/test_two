CREATE  TABLE IF NOT EXISTS `ptbc_test`.`customers` (
  `id` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL ,
  `phone` VARCHAR(30) ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;