create schema test_hiber;

create table test_hiber.employee (
   id         INT         NOT NULL     auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT         default NULL,
   PRIMARY KEY (id)
);