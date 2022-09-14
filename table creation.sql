create database CaseStudy;
use CaseStudy;
create table if not exists ProductCatalog(
id int primary key,
code varchar(255),
name varchar(255),
description varchar(255),
price double);
drop table ProductCatalog;
insert ignore into Product values(1,"P001","Product1","This is 1st product",778);
select * from productcatalog;
truncate productcatalog;