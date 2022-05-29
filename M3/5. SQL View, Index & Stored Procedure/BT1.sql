create database demo;

use demo;

create table  Products(
	Id int primary key not null,
	productCode varchar(45) not null,
	productName varchar(45) not null,
	productPrice double not null,
	productAmount int not null,
	productDescription varchar(450),
	productStatus varchar(45)
);

create unique index productCode_1 on products(productCode);
create index productCode_2 on products(productName, productPrice);

Explain select * from products 
limit 3;


create or replace view product_1
as 
	select productCode, productName, productPrice, productStatus 
    from products;
    
select * from product_1;

drop view product_1;

delimiter //
create procedure select_Pro()
	begin
		select * from products;
	end//
delimiter ;
call select_Pro();

delimiter //
create procedure insert_pro()
	begin
        insert into products (Id, productCode, productName, productPrice, productAmount, productDescription, productStatus) value (7,7,7,7,7,7,7);
	end//
delimiter ;
call insert_pro();
select * from products;

delimiter //
create procedure update_pro()
	begin
        update products set productStatus = 0 where id = 1;
	end//
delimiter ;
call update_pro();

delimiter //
create procedure delete_pro()
	begin
        delete from products where id = 2;
	end//
delimiter ;
call delete_pro;