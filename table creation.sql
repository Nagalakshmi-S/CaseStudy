create database CaseStudy;
use CaseStudy;
create table if not exists ProductCatalog(
id int primary key,
code varchar(255),
name varchar(255),
description varchar(255),
price double);
drop table ProductCatalog;
insert ignore into ProductCatalog values(1,"PRO01","product1","related to product",350);