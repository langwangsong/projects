create database day20;
use day20;
create table categories(
	id int primary key auto_increment,#主键自动增长
	name varchar(100) not null unique,#分类名称非空，唯一
	description varchar(255)#描述
);
TRUNCATE categories; #清空数据

create table books(
	id int primary key auto_increment,#主键自动增长
	name varchar(100),#书籍名称
	author varchar(100),#作者
	price float(8,2),#单价
	filename varchar(100),#书籍图片的文件名
	path varchar(100),#书籍图片的存放路径
	description varchar(255),#描述
	categoryid int,#引用的类型的id
	constraint category_id_fk foreign key (categoryid) references categories(id)#外键约束
);

create table customers(
	id int primary key auto_increment,#主键自动增长
	username varchar(100) not null unique,#用户名，唯一，必须有
	password varchar(100) not null,#密码
	phonenum varchar(100) not null,
	address varchar(255) not null,
	email varchar(100) unique 
);

create table orders(
	ordernum varchar(100) primary key,# 订单号
	totalQuantity int,#总数量
	totalPrice float(8,2),#总价
	status tinyint,#订单状态
	createDate timestamp,#生成日期
	customerId int,
	constraint customerId_fk foreign key (customerId) references customers(id)#外键约束
);
create table orderitems(
	id int primary key auto_increment,#主键自动增长
	quantity int,#数量
	price float(8,2),# 小计
	bookId int,
	ordernum varchar(100),
	constraint bookId_fk foreign key (bookId) references books(id),#外键约束
	constraint ordernum_fk foreign key (ordernum) references orders(ordernum)#外键约束
);
create table ordernum(
	prefix varchar(100) primary key,#前缀 20180201
	serialNum int #序号 00000001
);

select * from ordernum;

create table resources(
	id int primary key auto_increment,#主键自动增长
	name varchar(100) not null unique,#资源名称
	uri varchar(255)#资源对应的URI地址
);
create table roles(
	id int primary key auto_increment,#主键自动增长
	name varchar(100) not null unique,#角色名称
	description varchar(255)#描述
);
create table users(
	id int primary key auto_increment,#主键自动增长
	username varchar(100) not null unique,#用户名
	password varchar(100)#密码
);
create table resource_role(
	res_id int,
	role_id int,
	primary key(res_id,role_id),
	constraint res_id_fk foreign key (res_id) references resources(id),#外键约束
	constraint role_id_fk1 foreign key (role_id) references roles(id)
);
create table role_user(
	user_id int,
	role_id int,
	primary key(user_id,role_id),
	constraint user_id_fk foreign key (user_id) references users(id),#外键约束
	constraint role_id_fk2 foreign key (role_id) references roles(id)
);
select * from role_user;