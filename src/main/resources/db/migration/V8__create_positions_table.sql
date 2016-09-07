CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` FLOAT NULL,
  `longitude` FLOAT NULL,
  `altitude` FLOAT NULL,
  `current_time` DATETIME NULL,
  `run_id` INT NULL,
  `version` INT NULL,
  `created` TIMESTAMP NULL,
  `modified` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_position_to_runs_idx` (`run_id` ASC),
  CONSTRAINT `fk_position_to_runs`
    FOREIGN KEY (`run_id`)
    REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
