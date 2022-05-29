create database QuanLyBanHang;

create table Customer(
cId int not null primary key,
cName varchar(45) not null,
cAge int
);

create table oders(
oId int not null primary key,
cId int not null,
cName date not null,
oTotalPrice double not null,
foreign key (cId) references Customer (cId)
);

create table Product(
pId int not null primary key,
pName varchar(45) not null,
pPrice double not null
);

create table OrderDetail1(
oId int not null,
pId int not null,
odQTY int not null,
foreign key (oId) references oders (oId),
foreign key (pId) references Product (pId)
);