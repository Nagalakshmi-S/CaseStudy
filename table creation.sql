create database CaseStudy;
use CaseStudy;

drop table ProductCatalog;
insert ignore into Product values(2,"P002","Product2","This is 2nd product",990),(3,"P003","Product3","This is 3rd product",974),(4,"P004","Product4","This is 4th product",596);
select * from product;
truncate inventoryitem;

select * from inventoryitem;

drop table inventoryitem;
insert into inventoryItem values(103,674,"P003"),(104,259,"P004");

