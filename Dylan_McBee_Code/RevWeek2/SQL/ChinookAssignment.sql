/*
Dylan McBee Revature Associate Workbook Assignment

*/

--Section 2

--Problem 2.1
--Select all records from the employee table.

SELECT * FROM EMPLOYEE;
/
--Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
/
--Select all records from the Employee table where first name is Andrew 
--and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE 
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO is null;
/
--Problem 2.2
--Select all albums in Album table and sort result set in descending order 
--by title.

SELECT * FROM ALBUM al
ORDER BY TITLE DESC;
/
--Select first name from Customer and sort result set in ascending order by city

SELECT FIRSTNAME, CITY FROM CUSTOMER
ORDER BY CITY;
/
--Problem 2.3
--Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Oldies');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Audio Book');
SELECT * FROM GENRE;
/
--Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'McBee', 'Dylan', 'IT Staff', TO_DATE('1995-1-26 00:00:00','yyyy-mm-dd
hh24:mi:ss'), TO_DATE('2017-5-15 00:00:00' , 'yyyy-mm-dd hh24:mi:ss'),
'1312 W 300 S', 'Tipton', 'IN', 'United States', '46072', ' (317) 385-2508',
' (876) 543-2100', 'mcbeedylan@gmail.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'McB', 'Dyl', 'IT Staff', TO_DATE('1995-1-27 00:00:00','yyyy-mm-dd
hh24:mi:ss'), TO_DATE('2017-5-15 00:00:00' , 'yyyy-mm-dd hh24:mi:ss'),
'1405 W Ashland', 'Muncie', 'IN', 'United States', '47303', ' (765) 438-2521',
' (876) 542-2100', 'dhmcbee@bsu.edu');
/


