create database People;
use People;
create table Person (
    id int primary key auto_increment,
    age int,
    salary double,
    passport char(10),
    address varchar(200),
    dateOfBirth date,
    dateTimeCreate datetime,
    timeToLunch time,
    letter text
);
insert into Person values
(1, 20, 500.00, 'MP35435435','Surganova street 15, apt 98', '2002-08-13',
'2020-12-23 12:25:53', '12:25:53', 'Denote simple fat denied add worthy little use.
As some he so high down am week. Conduct esteems by cottage to pasture we winding. On assistance he cultivated considered frequently.
Person how having tended direct own day man. Saw sufficient indulgence one own you inquietude sympathize.'),
(2, 18, 0.00, 'MP43554454','Bogdanovicha street 27, apt 123', '2004-05-03',
 '1980-11-15 08:37:30', '08:37:30', 'Talking chamber as shewing an it minutes. Trees fully of blind do. Exquisite favourite at do extensive
listening. Improve up musical welcome he. Gay attended vicinity prepared now diverted. Esteems it ye sending reached as. Longer lively her
design settle tastes advice mrs off who.'),
(3, 38, 1920.40, 'MP35435435','Nezavisimosti square 114, apt 10', '1984-06-30',
 '2023-01-01 00:00:01', '00:00:01', 'Marianne or husbands if at stronger ye. Considered is as middletons uncommonly. Promotion perfectly ye
consisted so. His chatty dining for effect ladies active. Equally journey wishing not several behaved chapter she two sir. Deficient procuring
favourite extensive you two. Yet diminution she impossible understood age.'),
(4, 54, 4039.65, 'MP35435435','Yakuba Kolasa street 36, apt 76', '1970-12-09',
 '2003-07-29 14:10:43', '14:10:43', 'Denote simple fat denied add worthy little use.
As some he so high down am week. Conduct esteems by cottage to pasture we winding. On assistance he cultivated considered frequently.
Person how having tended direct own day man. Saw sufficient indulgence one own you inquietude sympathize.'),
(5, 23, 890.30, 'MP35435435','Moskovskaya street 5, apt 1', '1999-05-23',
 '1999-02-20 04:15:23', '04:15:23', 'Behind sooner dining so window excuse he summer. Breakfast met certainty and fulfilled propriety led.
Waited get either are wooded little her. Contrasted unreserved as mr particular collecting it everything as indulgence. Seems ask meant merry
could put. Age old begin had boy noisy table front whole given.');
select * from Person where age > 21 order by dateTimeCreate;
