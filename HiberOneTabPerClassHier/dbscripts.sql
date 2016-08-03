create user tutorial;

--Not no need to run the below script in DB at all
--as Hiber will generate if hbm2ddl.auto is set to create
--however as a good practise its good to create via sql
--and then set hbm2ddl as validate, so the db is
--not dropped and overwritten

CREATE TABLE `person` (
	`person_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`firstname` VARCHAR(50) NULL DEFAULT NULL,
	`lastname` VARCHAR(50) NULL DEFAULT NULL,
	`joining_date` DATE NULL DEFAULT NULL,
	`department_name` VARCHAR(50) NULL DEFAULT NULL,
	`discriminator` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`person_id`)
)