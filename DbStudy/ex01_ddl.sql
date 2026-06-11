# ddl 활용 -  create, alter, drop
USE member_db;

DROP TABLE IF EXISTS visit_history;
DROP TABLE IF EXISTS members;

CREATE TABLE members (
	mem_id CHAR(8) NOT NULL PRIMARY KEY,
    mem_name VARCHAR(10) NOT NULL,
    mem_number TINYINT NOT NULL,
    addr CHAR(2) NOT NULL,
    phone1 CHAR(3),
    phone2 CHAR(8),
    height TINYINT UNSIGNED,
    debut_date DATE
);


CREATE TABLE visit_history (
	visit_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mem_id CHAR(8),
    visited_at DATE,
    FOREIGN KEY(mem_id) REFERENCES members(mem_id)
		ON DELETE SET NULL

);

CREATE DATABASE IF NOT EXISTS db_ddl;
use db_ddl;
          
create table customers ( 
cust_id int not null primary key auto_increment,
cust_name varchar(30) not null,
phone varchar(30) unique,
age smallint check(age between 0 and 100),
join_dt date default(current_date())
);

