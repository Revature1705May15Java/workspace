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
--Insert two new records into Customer table

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY,
STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(60, 'Mark', 'Fisch', null, '1564 Main Street', 'Cincinnatti', 'OH',
'USA', '41073', '+1 (333) -456-7891', null, 'mf@hotmail.com', 4);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY,
STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(61, 'Larry', 'Hawl', null, '1560 Main Street', 'Indianapolis', 'IN',
'USA', '46170', '+1 (765) -456-7821', null, 'lh@hotmail.com', 3);
/
--Problem 2.4
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter', 
EMAIL = 'robertwalter@yahoo.ca'
WHERE CUSTOMERID = 32;
/
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE ARTIST SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
--Problem 2.5
--Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
--Problem 2.6
--Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
/
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
/
--Problem 2.7
--Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

alter table invoice
drop constraint FK_INVOICECUSTOMERID;
/
alter table invoice
add constraint FK_INVOICECUSTOMERID
foreign key (customerid)
references customer (customerid)
on delete cascade;
/
alter table invoiceline
drop constraint FK_INVOICELINEINVOICEID;
/
alter table invoiceline
add constraint FK_INVOICELINEINVOICEID
foreign key (invoiceid)
references invoice (invoiceid)
on delete cascade;
/
delete from customer
where customerid = 32;
/
--Problem 3.1
--Create a function that returns the current time.
create or replace function getSysdate
return varchar2 is

  l_sysdate varchar2(60);

begin

  SELECT TO_CHAR(SYSTIMESTAMP, 'HH24:MI:SS')
  into l_sysdate
  from dual;
  

  return l_sysdate;

end;
/
DECLARE
  v_Return varchar2(60);
BEGIN

  v_Return := GETSYSDATE();
DBMS_OUTPUT.PUT_LINE('v_Return = ' || v_Return);

  :v_Return := v_Return;
END;

