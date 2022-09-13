create database CaseStudy;
use CaseStudy;
create table if not exists productCatalog(
id BIGINT primary key,
code varchar(255),
name varchar(255),
description varchar(255),
price double);