create database author;
use author;
create table authors(authorID primary key nvarchar(20) not null,name nvarchar(20) not null,age int not null,country nvarchar(20) not null);

create table books(ISBN nvarchar(20) not null primary key ,title nvarchar(40) not null,authorID nvarchar(20) not null,constraint auth_fk foreign key (authorID) references authors (authorID),publisher nvarchar(40) not null,publishData nvarchar(20) not null,price real);