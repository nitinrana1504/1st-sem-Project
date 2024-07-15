use HotelMS;
show databases;
create table login(username varchar(25), password varchar(23));
select*from login;
insert into login values('darkworld','1234');

create table room(Room_no varchar(20), Availability varchar(20),Cleaning_status varchar(20),Price numeric(20), Bed_type varchar(20));
select * from room;

select Room_no from room where Availability = 'Available';
create table employee(name varchar(20), age numeric(20), gender varchar(20), job varchar(20), salary numeric(20), phone numeric(20), email varchar(20), aadhar varchar(20));
select* from employee;

create table driver(name varchar(20),age numeric(3),gender varchar(20), company varchar(20), car_name varchar(20), available varchar(20),location varchar(20));
select * from driver;

create table adminlogin(username varchar(25), password varchar(23));
insert into adminlogin values('nitinrana','123456');
select * from adminlogin;

create table department(department varchar(20), budget numeric(50));
insert into department value('Office','50000');
select * from department;
insert into department value('Housekeeping','40000');
insert into department value('Food','80000');
insert into department value('Kitchen','20000');
insert into department value('Security','60000');

create table customer(Document varchar(20), ID_NO varchar(30), Name varchar (20), Gender varchar(20), Country varchar(20), Room_no varchar(5),Check_In_Time varchar(80), Deposit varchar(10));
select * from customer;