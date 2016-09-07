CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL,
  `stop_time` DATETIME NULL,
  `version` INT NULL,
  `created` TIMESTAMP NULL,
  `modified` TIMESTAMP NULL,
  `device_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_RUN_TO_DEVICE_idx` (`device_id` ASC),
  CONSTRAINT `FK_RUN_TO_DEVICE`
    FOREIGN KEY (`device_id`)
    REFERENCES `fitness`.`devices` (`serial_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);