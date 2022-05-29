select * from `subject`
where Credit = (select max(Credit) from `subject`);

select * from `subject`
where subid = (select SubId from mark where mark = (select max(mark) from mark));

select  s.studentname, s.phone, s.address, avg(mark) from student s
join mark m on m.studentid= s.studentid
group by s.studentid
ORDER BY avg(mark) DESC;