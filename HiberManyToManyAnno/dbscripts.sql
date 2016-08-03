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
	PRIMARY KEY (`employee_id`)
)


CREATE TABLE `meeting` (
	`meeting_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`subject` VARCHAR(50) NOT NULL,
	`meeting_date` DATE NOT NULL,
	PRIMARY KEY (`meeting_id`)
)


CREATE TABLE `employee_meeting` (
	`employee_id` BIGINT(20) NOT NULL,
	`meeting_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`employee_id`, `meeting_id`),
	INDEX `FK_MEETING` (`meeting_id`),
	CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
	CONSTRAINT `FK_MEETING` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`meeting_id`)
)