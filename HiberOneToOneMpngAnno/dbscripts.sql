create user tutorial;

--Not no need to run the below script in DB at all
--as Hiber will generate if hbm2ddl.auto is set to create
--however as a good practise its good to create via sql
--and then set hbm2ddl as validate, so the db is
--not dropped and overwritten

/* EMPLOYEE table */
CREATE TABLE `employee` (
    `employee_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `birth_date` DATE NOT NULL,
    `cell_phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`employee_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=216
 
/* EMPLOYEEDETAIL table */
CREATE TABLE `employeedetail` (
    `employee_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `street` VARCHAR(50) NULL DEFAULT NULL,
    `city` VARCHAR(50) NULL DEFAULT NULL,
    `state` VARCHAR(50) NULL DEFAULT NULL,
    `country` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`employee_id`),
    CONSTRAINT `FKEMPL` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=216