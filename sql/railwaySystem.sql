 #last modify 2019.1.9
 #database
CREATE DATABASE railwaysystem;

USE railwaysystem;

#tables
#1
CREATE TABLE trainNumberInfo(
trainID INT PRIMARY KEY AUTO_INCREMENT,
trainNumber VARCHAR(255),
trainType INT(1),
startLocation VARCHAR(255),
endLocatuion VARCHAR(255),
startTime TIMESTAMP,
endTime TIMESTAMP,-
runTime VARCHAR(255)
);
#2
CREATE TABLE stationInfo(
stationID INT PRIMARY KEY AUTO_INCREMENT,
trainNumber VARCHAR(255),
stationNumber VARCHAR(255),
stationInfo VARCHAR(255),
startTime TIMESTAMP,
distance DECIMAL(10,2),
step INT
);

#3
CREATE TABLE seatInfo(
seatID INT PRIMARY KEY AUTO_INCREMENT,
roomNum VARCHAR(255),
seatLevel INT(1),
seatNum INT
);

#4
CREATE TABLE ticketInfo(
ticketID INT PRIMARY KEY AUTO_INCREMENT,
trainNumber VARCHAR(255),
startTime TIMESTAMP,
endTime TIMESTAMP,
startstation VARCHAR(255),
endstation VARCHAR(255),
roomNumber VARCHAR(255),
seatLevel INT(1),
spareSeatNum INT,
ticketPrice DECIMAL(10,2)
);

#5
CREATE TABLE ticketPurchaseInfo(
purchaseID INT PRIMARY KEY AUTO_INCREMENT,
trainNumber VARCHAR(255),
startTime TIMESTAMP,
endTime TIMESTAMP,
startstation VARCHAR(255),
endstation VARCHAR(255),
roomNumber VARCHAR(255),
seatNumber VARCHAR(255),
ticketPrice DECIMAL(10,2),
identityNumver VARCHAR(255),
purchaseTime TIMESTAMP
);
#6
CREATE TABLE customerInfo(
customerID INT PRIMARY KEY AUTO_INCREMENT,
customerLoginName VARCHAR(255),
customerName VARCHAR(255),
sex CHAR(1) CHECK (sex IN('M','F')),
identityNumber VARCHAR(255),
birthTime TIMESTAMP,
phoneCall VARCHAR(255),
customerPassword VARCHAR(255)
);
SELECT * FROM customerinfo;
#7
CREATE TABLE administrator(
administratorId INT PRIMARY KEY AUTO_INCREMENT,
administratorName VARCHAR(255),
administratorPassword VARCHAR(255)
);

#8
CREATE TABLE contactPeople(
contactPeopleId INT PRIMARY KEY AUTO_INCREMENT,
parentId INT,
contactId INT
);
SELECT * FROM contactPeople;
SELECT * FROM customerinfo;
#fake data
#1fake data
INSERT trainNumberInfo VALUES(NULL,'G9465',0,'合肥南','杭州东','2019-1-15-14-41','2019-1-15-17-34','2h53min');
INSERT trainNumberInfo VALUES(NULL,'G7004',1,'上海','南京','2019-1-20-8-00','2019-1-20-9-39','1h39min');
INSERT trainNumberInfo VALUES(NULL,'D3041',2,'武昌','上海虹桥','2019-3-20-9-24','2019-3-20-16-05','6h41min');
#2fake data
INSERT stationinfo VALUES(NULL,'G9465','hefeinan','合肥南','2019-1-15-14-41',100.0,1);
INSERT stationinfo VALUES(NULL,'G9465','nanjinnan','南京南','2019-1-15-15-41',100.0,2);
INSERT stationinfo VALUES(NULL,'G9465','jiangnin','江宁','2019-1-15-16-04',100.0,3);
INSERT stationinfo VALUES(NULL,'G9465','liyang','溧阳','2019-1-15-16-29',100.0,4);
INSERT stationinfo VALUES(NULL,'G9465','yixing','宜兴','2019-1-15-16-48',100.0,5);
INSERT stationinfo VALUES(NULL,'G9465','huzhou','湖州','2019-1-15-17-42',100.0,6);
INSERT stationinfo VALUES(NULL,'G9465','hangzhoudong','杭州东','2019-1-15-17-34',100.0,7);

INSERT stationinfo VALUES(NULL,'G7004','shanghai','上海','2019-1-20-8-00',100.0,1);
INSERT stationinfo VALUES(NULL,'G7004','nanjinnan','苏州','2019-1-20-8-25',100.0,2);
INSERT stationinfo VALUES(NULL,'G7004','jiangnin','无锡','2019-1-20-8-42',100.0,3);
INSERT stationinfo VALUES(NULL,'G7004','liyang','常州','2019-1-20-8-58',100.0,4);
INSERT stationinfo VALUES(NULL,'G7004','yixing','南京','2019-1-20-9-00',100.0,5);

INSERT stationinfo VALUES(NULL,'D3041','wuchang','武昌','2019-3-20-9-24',100.0,1);
INSERT stationinfo VALUES(NULL,'D3041','hankou','汉口','2019-3-20-9-43',100.0,2);
INSERT stationinfo VALUES(NULL,'D3041','honganxi','红安西','2019-3-20-10-23',100.0,3);
INSERT stationinfo VALUES(NULL,'D3041','machengbei','麻城北','2019-3-20-10-41',100.0,4);
INSERT stationinfo VALUES(NULL,'D3041','liuan','六安','2019-3-20-11-40',100.0,5);
INSERT stationinfo VALUES(NULL,'D3041','hefeinan','合肥南','2019-3-20-12-11',100.0,6);
INSERT stationinfo VALUES(NULL,'D3041','quanjiao','全椒','2019-3-20-12-57',100.0,7);
INSERT stationinfo VALUES(NULL,'D3041','nanjingnan','南京南','2019-3-20-13-21',100.0,8);
INSERT stationinfo VALUES(NULL,'D3041','zhengjiang','镇江','2019-3-20-13-56',100.0,9);
INSERT stationinfo VALUES(NULL,'D3041','danyang','丹阳','2019-3-20-14-12',100.0,10);
INSERT stationinfo VALUES(NULL,'D3041','changzhou','常州','2019-3-20-14-30',100.0,11);
INSERT stationinfo VALUES(NULL,'D3041','huishan','惠山','2019-3-20-14-45',100.0,12);
INSERT stationinfo VALUES(NULL,'D3041','wuxi','无锡','2019-3-20-15-11',100.0,13);
INSERT stationinfo VALUES(NULL,'D3041','suzhou','苏州','2019-3-20-15-29',100.0,14);
INSERT stationinfo VALUES(NULL,'D3041','kunshannan','昆山南','2019-3-20-15-43',100.0,15);
INSERT stationinfo VALUES(NULL,'D3041','shanghaihongqiao','上海虹桥','2019-3-20-16-45',100.0,16);

#3fake data
insert seatInfo values(null,'a1',0,50);
insert seatInfo values(null,'a2',0,50);
insert seatInfo values(null,'a3',0,50);

#4fake data
insert ticketInfo values(null,'G9465','2019-1-15-14-41','2019-1-15-17-34','合肥南','杭州东',10,0,20,50.0);
insert ticketInfo values(null,'G7004','2019-1-20-8-00','2019-1-20-9-39','上海','南京',10,1,20,50.0);
insert ticketInfo values(null,'D3041','2019-3-20-9-24','2019-3-20-16-05','武昌','上海虹桥',10,2,20,50.0);

#5void the user's purchase

#6fake data
INSERT customerinfo VALUES(NULL,'littlepage','小页','M','320685199811281515','1998-11-28','15132225252','root');
INSERT customerinfo VALUES(NULL,'zhangsan','张三','M','320685199710201515','1997-10-20','15132232255','root');
INSERT customerinfo VALUES(NULL,'lisi','李四','F','320685199506201515','1995-06-20','15132966233','root');
INSERT customerinfo VALUES(NULL,'wangwu','王五','F','320685199605101515','1996-05-10','15132232144','root');
INSERT customerinfo VALUES(NULL,'songsong','怂怂','M','320685199809091515','1998-09-09','15132214151','root');
#7fake data
INSERT administrator VALUES (NULL,'root','root','合肥南','杭州东');

