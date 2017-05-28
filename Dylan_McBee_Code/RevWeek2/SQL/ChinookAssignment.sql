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
/
--create a function that returns the length of a mediatype from the mediatype table
create or replace function getLengthMediaType(id in number)
return number is

  mtLength number;

begin

  select length(name) 
  into mtLength
  from mediatype
  where mediatypeid = id;
  

  return mtLength;

end;
/
DECLARE
  ID NUMBER;
  v_Return NUMBER;
BEGIN
  ID := 1;

  v_Return := GETLENGTHMEDIATYPE(
    ID => ID
  );

DBMS_OUTPUT.PUT_LINE('v_Return = ' || v_Return);

  :v_Return := v_Return;
END;
/
--Problem 3.2
--Create a function that returns the average total of all invoices
create or replace function averageTotal
return number is

  avgTotal number(7,2);

begin

  select avg(total) 
  into avgTotal
  from invoice;
  

  return avgTotal;

end;
/
DECLARE
  v_Return NUMBER;
BEGIN

  v_Return := AVERAGETOTAL();

DBMS_OUTPUT.PUT_LINE('v_Return = ' || v_Return);

  :v_Return := v_Return;
END;
/
--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION maxTrack
return number is
  bigTrack number;
begin

select max(unitprice) 
into bigTrack
from track;

return bigTrack;

end;
/
DECLARE
  v_Return NUMBER;
BEGIN

  v_Return := MAXTRACK();
DBMS_OUTPUT.PUT_LINE('v_Return = ' || v_Return);

  :v_Return := v_Return;

END;
/
--Problem 3.3
--Create a function that returns the average price of invoiceline items 
--in the invoiceline table
create or replace function averagePrice
return number is

  avgPrice number(7,2);

begin

  select avg(unitprice) 
  into avgPrice
  from invoiceline;
  

  return avgPrice;

end;
/
DECLARE
  v_Return NUMBER;
BEGIN

  v_Return := AVERAGEPRICE();

DBMS_OUTPUT.PUT_LINE('v_Return = ' || v_Return);
  :v_Return := v_Return;

END;
/
--Problem 3.4
--Create a function that returns all employees who are born after 1968.
select * from employee
where birthdate > '31-DEC-68';
/

CREATE OR REPLACE FUNCTION youngEmployees
RETURN SYS_REFCURSOR
    AS st_cursor SYS_REFCURSOR;
    BEGIN
      OPEN st_cursor FOR
      SELECT * FROM Employee WHERE birthdate >= '01-JAN-69';
      RETURN st_cursor;
    END;
/

select youngemployees from dual;
/
--Problem 4.1
--Create a stored procedure that selects the first and last names of all the employees
create or replace procedure getFirstAndLast(sys_cur out SYS_REFCURSOR)
  is
  begin
    open sys_cur for
    select firstname, lastname from employee;
  end;
/
variable rc refcursor;
exec getfirstandlast( :rc );
print rc;

--Problem 4.2
-- Create a stored procedure that updates the personal information of an employee.
create or replace PROCEDURE updateEmployee (e_id number, e_ln varchar2, 
e_fn varchar2, e_address varchar2, e_city varchar2, e_state varchar2, 
e_country varchar2, e_postalcode varchar2, e_phone varchar2, 
e_fax varchar2, e_email varchar2)
 
 as
 begin 
 
 update employee
 set lastname = e_ln, firstname = e_fn, address = e_address, city = e_city, 
 state = e_state, country = e_country, postalcode = e_postalcode, phone = e_phone,
 fax = e_fax, email = e_email
 where employeeid = e_id;
 
 end;
/
call updateEmployee(10, 'McBee', 'John', '1311 W 300 S', 'Tiptoe', 'IN',
'United States', '46073', '+1 (316) 384-2508', '+1 (666) 666-6666', 'md@gmail.com');
/
-- Create a stored procedure that returns the managers of an employee.
create or replace procedure getManagers(e_id in number,  m_id  out number)
as
begin
  select reportsto 
  into m_id
  from employee
  where employeeid = e_id;
end;
/
--Problem 4.3
--Create a stored procedure that returns the name and company of a customer.
create or replace procedure getCustomer(c_id in number, c_fn out varchar2, 
c_ln out varchar2, c_company out varchar2)
as
begin
  select firstname, lastname, company
  into c_fn, c_ln, c_company
  from customer
  where customerid = c_id;
end;
/
--Problem 5.0
--Create a transaction that given a invoiceId will delete that invoice
--(There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(id IN NUMBER)
  IS
  BEGIN
    SAVEPOINT start_tran;
    DELETE FROM Invoice WHERE invoiceid = id;
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK TO start_tran;
    RAISE;
  END;
/
--Create a transaction nested within a stored procedure that inserts 
--a new record in the Customer table
CREATE OR REPLACE PROCEDURE addCustomer(c_id NUMBER, c_fn varchar2, c_ln varchar2,
c_company varchar2, c_address varchar2, c_city varchar2, c_state varchar2,
c_country varchar2, c_pc varchar2, c_phone varchar2, c_fax varchar2, c_email varchar2,
c_repid number)
  IS
  BEGIN
    SAVEPOINT start_tran;
    insert into customer values (c_id, c_fn, c_ln, c_company, c_address, c_city, c_state,
    c_country, c_pc, c_phone, c_fax, c_email, c_repid);
  EXCEPTION
  WHEN OTHERS THEN
  ROLLBACK TO start_tran;
  RAISE;
END;
/
--Problem 6.1
--Create an after insert trigger on the employee table fired after 
--a new record is inserted into the table.
CREATE OR REPLACE TRIGGER em_after_trigger
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
  dbms_output.put_line('Did something');
END;
/
--Create an after update trigger on the album table that fires 
--after a row is inserted in the table
CREATE OR REPLACE TRIGGER em_afterupdate_trigger
AFTER UPDATE ON Album
FOR EACH ROW
BEGIN
  dbms_output.put_line('Did something');
END;
/
--Create an after delete trigger on the customer table 
--that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER em_afterdelete_trigger
AFTER DELETE ON Customer
FOR EACH ROW
BEGIN
  dbms_output.put_line('Did something');
END;
/
--Problem 6.2
--Create an instead of trigger that restricts the deletion of any invoice 
--that is priced over 50 dollars
CREATE OR REPLACE TRIGGER inv_instead_trigger
INSTEAD OF DELETE ON INVOICE
BEGIN
IF
INVOICE.TOTAL <= 50
THEN
DELETE FROM INVOICE; 
END;
/
--Problem 7.1
--Create an inner join that joins customers and orders 
--and specifies the name of the customer and the invoiceId.
select cu.firstname, cu.lastname, inv.invoiceid
from customer cu
inner join invoice inv on cu.customerid = inv.customerid;
/
--Problem 7.2
--Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
select cu.customerid, cu.firstname, cu.lastname, inv.invoiceid, inv.total
from customer cu
full outer join invoice inv on cu.customerid = inv.customerid;
/
--Problem 7.3
--Create a right join that joins album and artist specifying artist name and title.
select art.name, al.title
from album al
right join artist art on al.artistid  = art.artistid;
/
--Problem 7.4
--Create a cross join that joins album and artist and sorts by 
--artist name in ascending order.
select *
from album al
cross join artist art
order by art.name asc;
/
--Problem 7.5
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM employee e1, employee e2
WHERE e1.reportsto=e2.employeeid;
/
--Problem 8.1
--Create a clustered index on of table of your choice


--Problem 9.1
--Create a .bak file for the Chinook database.
CREATE CLUSTER personnel
   (department NUMBER(4))
SIZE 512 
STORAGE (initial 100K next 50K);
/
