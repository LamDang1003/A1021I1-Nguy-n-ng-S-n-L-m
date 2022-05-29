create database QuanLySinhVien;

USE QuanLySinhVien;
       
select studentName
from student 
where studentName like 'h%';

select *from class
where startDate like '_____12%';

select * from `subject`
where credit =5
union
select * from `subject`
where credit =3
union
select * from `subject`
where credit =4;

select * from `subject`
where credit between 3 and 5;

UPDATE `quanlysinhvien`.`student` SET `classId` = '2' WHERE (`StudentId` = '1');



