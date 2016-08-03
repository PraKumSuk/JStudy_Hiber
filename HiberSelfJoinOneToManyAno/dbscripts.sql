create user tutorial;

--Not no need to run the below script in DB at all
--as Hiber will generate if hbm2ddl.auto is set to create
--however as a good practise its good to create via sql
--and then set hbm2ddl as validate, so the db is
--not dropped and overwritten

CREATE TABLE `employee` (
	`employee_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`firstname` VARCHAR(50) NULL DEFAULT NULL,
	`lastname` VARCHAR(50) NULL DEFAULT NULL,
	`manager_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`employee_id`),
	CONSTRAINT `FK_MANAGER` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`employee_id`)
)