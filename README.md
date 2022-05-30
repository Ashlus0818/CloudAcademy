# CloudAcademy
使用Tomcat9, Sql server, 啟動後網址http://localhost:8080/SpringMvcCloudAcademyProject/index 

Database name:AshlusDB

SQL語法:
create table BeforeCompleteTask(
	id int not null primary key identity(1,1),
	context nvarchar(50) not null,
);
insert into BeforeCompleteTask(context) values('rabbit');
select *from BeforeCompleteTask

create table AfterCompleteTask(
	id int not null primary key identity(1,1),
	context nvarchar(50) not null,
);
insert into AfterCompleteTask(context) values('dog');
select *from AfterCompleteTask
