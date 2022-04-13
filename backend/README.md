# 2021/11/2

## add order
selected result should be ordered by name like below. 
```
@Select("select * from course order by `name` limit #{offset},5")
List<Course> findAll(int offset);
```

## debug jsp page
If you enter page 0 or less, the sql code will be invalid and you will get 500 error.
<br>
So I just add "min" property to input element,so that user can't enter bad num of pages.

```html
<input type="number" min="1" name="page" id="pageNum" placeholder="${page}">
```
# 2021/11/1

## SQL Scripts

add the sql cods for database init to test.

```mysql
create database education;
use education;

create table course(
                       id int primary key auto_increment,
                       name varchar(20) not null,
                       hours double not null,
                       description text,
                       syllabus text,
                       teacher int
);

create table user(
                     id int primary key auto_increment,
                     username varchar(20),
                     password varchar(20),
                     role varchar(20)
);
```
and sql for test:
```mysql
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA1',2,'a kind of programing language','self-learn',1);
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA2',2,'a kind of programing language','self-learn',2);
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA3',2,'a kind of programing language','self-learn',4);
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA4',2,'a kind of programing language','self-learn',4);
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA5',2,'a kind of programing language','self-learn',5);
insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values('JAVA6',2,'a kind of programing language','self-learn',4);

insert into user values(null, 'Lisa', '123456', 'Teacher');

select * from user;
select * from course;
```

sql to delete database:
```mysql
DROP DATABASE education;
```

/

what's more, please edit the file called [database.properties](src/main/resources/database.properties) which takes charge of connection with your database.
## Stage3

finish:
1. the front-end with JSP
2. pagination by sql code ***limit offset,pageSize***

# 2021/10/28

finish the CRUD of Course with Restful API.