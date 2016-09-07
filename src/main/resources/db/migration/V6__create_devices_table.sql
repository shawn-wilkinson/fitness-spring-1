CREATE TABLE `fitness`.`devices` (
  `serial_number` VARCHAR(45) NOT NULL,
  `product` VARCHAR(45) NULL,
  `category` ENUM('RUN', 'SWIM', 'BIKE', 'LIFT') NULL,
  `user_id` INT NULL,
  `version` INT NULL,
  `created` TIMESTAMP NULL,
  `modified` TIMESTAMP NULL,
  PRIMARY KEY (`serial_number`),
  INDEX `fk_device_to_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_device_to_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
