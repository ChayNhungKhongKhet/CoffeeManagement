create database coffee_management
go
use coffee_management
go
create table [role] 
(
	id int identity primary key,
	[name] nvarchar(20),
	amount_per_hour decimal(5,3)
);
go
create table employee
(
	id int identity primary key,
	[user_name] nvarchar(40) unique,
	[name] nvarchar(40),
	[password] varchar(20),
	phone char(10),
	[address] nvarchar(50)
);
go

create table employee_role
(
	employee_id int,
	role_id int,
	start_job_date date,
	quit_job_date date default null
	primary key(employee_id,role_id)
);
go

alter table employee_role
	add constraint FK_employee_role_employee_id foreign key(employee_id) 
			references employee(id)
			on update cascade,
		constraint FK_employee_role_role_id foreign key(role_id) 
			references role(id)
			on update cascade
go

create table [table]
(
id int identity primary key,
area nvarchar(10),
[state] nvarchar(10) default N'trống'
);
go

create table category
(
id int identity primary key,
[name] nvarchar(30)
);
go

create table supplier
(
id int identity primary key,
[name] nvarchar(60),
phone char(10),
[address] nvarchar(70)
);
go

create table receipt
(
id int identity primary key,
supplier_id int,
[date] varchar(10),
constraint FK_receipt_supplier_id 
foreign key(supplier_id) 
references supplier(id)
on update cascade
);
go

create table ingredient
(
id int identity primary key,
ingredient_category varchar(20),
[name] nvarchar(50),
degree nvarchar(15)
);
go

create table receipt_detail
(
receipt_id int,
ingredient_id int,
quanlity int,
price decimal(5,3),
employee_id int,
primary key(receipt_id,ingredient_id)
);
go

alter table receipt_detail
	add constraint 
			FK_receipt_detail_receipt_id foreign key(receipt_id) 
			references receipt(id)
			on update cascade,
		constraint
			FK_receipt_detail_ingredient_id foreign key(ingredient_id)
			references ingredient(id)
			on update cascade,
		constraint
			FK_receipt_detail_employee_id foreign key(employee_id)
			references employee(id)
			on update cascade
go

create table used_ingredient
(
id int identity,
ingredient_id int,
quanlity_on_machine float,
quanlity_emm_enter float,
use_date date,
primary key(id),
constraint FK_used_ingredient_ingredient_id 
foreign key(ingredient_id) 
references ingredient(id)
on update cascade
);
go

create table product 
(
id int identity primary key,
category_id int,
[name] nvarchar(30),
price decimal(5,3),
constraint FK_product_category_id 
foreign key(category_id)
references category(id)
on update cascade
);
go

create table recipe
(
product_id int,
ingredient_id int,
quanlity float,
primary key(product_id,ingredient_id)
);
go

alter table recipe
	add constraint FK_recipe_product_id 
			foreign key(product_id) references product(id)
			on update cascade,
		constraint FK_recipe_ingredient_id
			foreign key(ingredient_id) references ingredient(id)
			on update cascade
go

create table [order]
(
id int identity primary key,
employee_id int,
table_id int,
date_time varchar(30),
[state] nvarchar(25) default N'đã thanh toán',
);
go

alter table [order]
	add constraint FK_order_employee_id foreign key(employee_id)
			references employee(id)
			on update cascade,
		constraint FK_order_table_id foreign key(table_id)
			references [table](id)
			on update cascade

go

create table timesheet
(
id int identity primary key,
full_or_part varchar(20),
employee_id integer,
start_time varchar(7),
end_time varchar(7),
[date] varchar(15),
note nvarchar(100)
constraint FK_time_sheet_employee_id foreign key(employee_id) 
references employee(id)
on update cascade
);
go

create table size
(
id int identity primary key,
name varchar(2),
extra_price decimal(5,3)
);
go

create table product_size
(
id_product_size int identity primary key,
product_id int,
size_id int
);
go

alter table product_size
	add constraint FK_product_size_product_id foreign key(product_id)
			references product(id)
			on update cascade,
		constraint FK_product_size_size_id foreign key(size_id)
			references size(id)
			on update cascade
go

create table order_detail
(
order_id int,
product_id int,
product_size_id int,
quantity int,
price decimal(5,3),
primary key(order_id,product_id)
);
go

alter table order_detail
	add constraint FK_order_detail_order_id foreign key(order_id)
			references [order](id)
			on update cascade,
		constraint FK_order_detail_product_id foreign key(product_id)
			references product(id)
			on update cascade		
go


insert into [role]([name],amount_per_hour)values
(N'Nhân viên bán hàng',40.000),
(N'Nhân viên phục vụ',30.000),
(N'Quản lý',60.000),
(N'Quản lý kho',50.000),
(N'Admin',99.000)
go


insert into employee([user_name],[name],[password],phone,[address])values
('NVTan',N'Phạm Ngọc Tân','123','0813637076',N'Quảng Bình'),
('NVTuan',N'Nguyễn Văn Anh Tuấn','123','0842536532',N'Dak Lak'),
('NVNa',N'Vũ Lê Na','123','0924141532',N'Dak Lak'),
('NVThi',N'Hồ Thị Ái Thi','123','0891247192',N'Huế'),
('NVThu',N'Lê Thị Hoài Thu','123','0120384102',N'Quảng Nam'),
('Admin',N'None','12345','0741242124',N'Quảng Bình')
go
set dateformat dmy
go
insert into employee_role(employee_id,role_id,start_job_date,quit_job_date)values
(1,2,'20/01/2021','20/10/2021'),
(1,3,'20/01/2021',null),
(3,1,'14/03/2021',null),
(4,2,'10/03/2021',default),
(5,4,'30/01/2021',default),
(2,2,'21/04/2021',default),
(3,2,'15/01/2021',default),
(5,1,'20/12/2021',null),
(6,5,'01/01/2021',null)
go
--select * from timesheet
--insert into timesheet(full_or_part,employee_id,start_time,end_time,[date],note)values
--('full',1,'',)


go
insert into size([name],extra_price)
	values ('M',0.000),
		   ('L',5.000),
		   ('XL',10.000);
go
insert into category([name])
	values (N'Cà phê'),
		   (N'Trà sữa'),
		   (N'Trà'),
		   (N'Sinh tố, nước ép');
go
insert into product(category_id,[name],price)
	values (1,N'Cà phê sữa',17.000),
		   (1,N'Cà phê đen',15.000),
		   (2,N'Trà sữa truyền thống',25.000),
		   (2,N'Trà sữa trứng nướng',30.000),
		   (3,N'Trà vải',30.000),
		   (3,N'Trà táo',30.000),
		   (4,N'Dưa hấu',30.000),
		   (4,N'Thơm',30.000);
go 
insert into product_size(product_id,size_id)
	values(1,1),
		  (1,2),
		  (1,3),
		  (2,1),
		  (2,2),
		  (2,3),
		  (3,1),
		  (3,2),
		  (3,3),
		  (4,1),
		  (4,2),
		  (4,3),
		  (5,1),
		  (5,2),
		  (5,3),
		  (6,1),
		  (6,2),
		  (6,3),
		  (7,1),
		  (7,2),
		  (7,3),
		  (8,1),
		  (8,2),
		  (8,3)
go
insert into [table](area)values
(N'Tầng 1'),
(N'Tầng 1'),
(N'Tầng 1'),
(N'Tầng 1'),
(N'Tầng 1'),
(N'Tầng 2'),
(N'Tầng 2'),
(N'Tầng 2'),
(N'Tầng 2'),
(N'Tầng 2'),
(N'Tầng 3'),
(N'Tầng 3'),
(N'Tầng 3'),
(N'Tầng 3'),
(N'Tầng 3')
go
insert into [order](employee_id,table_id,date_time)values
(1,11,'20/12/2021'),
(2,2,'20/12/2021'),
(3,4,'20/12/2021'),
(4,3,'20/12/2021'),
(1,5,'20/12/2021'),
(4,10,'20/12/2021'),
(1,9,'20/12/2021')

go
insert into order_detail(order_id,product_id,product_size_id,quantity,price)values
(1,1,1,10,17.000),
(2,3,3,3,35.000),
(3,4,1,5,30.000),
(5,5,1,2,30.000),
(6,6,3,2,40.000),
(7,7,1,3,30.000)

go
insert into supplier([name],phone,[address])values
(N'Cửa hàng nguyên liệu pha chế trà sữa và cafe ông Tân','0132481234',N'Đà Nẵng')
go
insert into ingredient(ingredient_category,[name],degree)values
(N'Đá-chanh-đường',N'Chanh','kg'),
(N'Đá-chanh-đường',N'Đường','kg'),
(N'Đá-chanh-đường',N'Đá',N'kg'),
(N'Trái cây',N'Vải thiều','kg'),
(N'Trái cây',N'Táo','kg'),
(N'Trái cây',N'Cà rốt','kg'),
(N'Trái cây',N'Dưa hấu','kg'),
(N'Trái cây',N'Thơm','kg'),
(N'Nguyên liệu trà sữa',N'Sữa đặc',N'kg'),
(N'Nguyên liệu trà sữa',N'Bột trà sữa','kg'),
(N'Nguyên liệu trà sữa',N'Trứng gà',N'quả'),
(N'Nguyên liệu cà phê',N'Hạt cà phê đen','kg'),
(N'Nguyên liệu topping',N'Bột năng','kg'),
(N'Nguyên liệu topping',N'Bột lọc','kg'),
(N'Nguyên liệu topping',N'Bột thạch dừa','kg'),
(N'Phụ gia','vani','kg')
go
insert into receipt(supplier_id,[date])values
(1,'04/02/2022'),--1
(1,'04/02/2022'),--2
(1,'05/02/2022'),--3
(1,'04/02/2022'),--4
(1,'05/02/2022'),--5
(1,'10/05/2022'),--6
(1,'28/04/2022'),--7
(1,'10/05/2022')--8
go


insert into receipt_detail(receipt_id,ingredient_id,quanlity,price,employee_id)values
(1,1,2,15.000,5),
(2,2,3,22.000,1),
(3,3,4,22.000,5),
(4,4,1,12.000,1),
(5,5,2,75.000,5),
(6,6,4,57.000,5),
(7,7,5,43.000,1),
(8,8,8,87.000,5),
(1,9,3,55.000,5),
(2,10,8,19.000,5),
(3,11,8,22.000,1),
(4,12,2,42.000,5),
(5,13,7,15.000,1),
(6,14,9,42.000,5),
(7,15,5,16.000,1),
(8,16,1,21.000,5)
go

insert into recipe(product_id,ingredient_id,quanlity)values
(1,12,0.1),
(1,9,0.1),
(2,10,0.1),
(4,11,1),
(3,10,0.1),
(4,10,0.1),
(5,4,0.2),
(6,5,0.2),
(7,7,0.2),
(8,8,0.2)

