--join all tables

SELECT t.name as "Track Name", al.title as "Album Name", m.name as "Media type",
g.name as "Genere Type", ar.name as "Artist Name", c.firstname as "Customer name",
e.firstname as "employee name", i.invoicedate as "Invoice Date",
il.invoiceLineId as "Invoice Number", p.name as "Playlist Name", pt.PLAYLISTID, pt.TRACKID,
t.name as "track name"
From track t
inner join invoiceLine il on il.TRACKID = t.TRACKID
inner join album al on t.ALBUMID= al.ALBUMID
inner join artist ar on al.ARTISTID = ar.ARTISTID
inner join MEDIATYPE m on t.MEDIATYPEID = m.MEDIATYPEID
inner join GENRE g on t.GENREID = g.GENREID
inner join playlisttrack pt on t.trackId = pt.trackId
inner join playlist p on pt.playlistId = p.playlistId
inner join invoice i on il.INVOICEID = i.INVOICEID
inner join customer c on i.CUSTOMERID = c.CUSTOMERID
inner join EMPLOYEE e on c.SUPPORTREPID = e.EMPLOYEEID;
/


--Workbook section 1 done in class together
-- Workbook 2.1 - Selection

select * from employee;

SELECT * FROM employee
WHERE lastname = 'King';

SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;
/

-- Workbook 2.2 - Order by
SELECT * FROM album
ORDER BY title DESC;

Select firstname FROM customer
ORDER BY city; -- default sort is ascending order
/
-- Workbook 2.3 - insert into

INSERT INTO Genre
VALUES (26, 'soundtrack');

select * from employee;

INSERT INTO employee
VALUES (9, 'Boor','Chantel','IT staff',6, '12-Dec-93','11-MAY-15', '1871 Bentley Drive', 'Frisco','TX', 'USA', '75033', '214-504-6723','214-504-6723','Chantel.boor@sbcglobal.net');

INSERT INTO employee
VALUES (10, 'Himura','Airi','IT staff',6, '4-JUL-93','11-JUN-15', '1871 Bentley Drive', 'Frisco','TX', 'USA', '75033', '555-504-6723','555-504-6723','a.h@sbcglobal.net');

select * from customer;

INSERT INTO customer
Values (60, 'Alex','Baker', null, '112 Dog', 'Bark','TX','USA','1234','555-111-1234', null, 'a.b@gmail.com',9);

INSERT INTO customer
Values (61, 'Ann','Carter', null, '112 cat', 'meow','TX','USA','1234','555-222-1234', null, 'a.c@gmail.com',9);
/

-- Workbook 2.4 - update

UPDATE customer
SET firstname = 'Robert', lastname = 'Walker'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist
Set name = 'CCR'
Where name = 'Creedence Clearwater Revival';
/
-- Workbook 2.5 and 2.6 - like and between

SELECT * From invoice
WHERE billingaddress like 'T%';

SELECT * From invoice
WHERE total BETWEEN 15 AND 50;

SELECT * From employee
WHERE hiredate BETWEEN '1-JUN-2003' AND '1-MAR-2004';

/
-- Workbook 2.7 - delete

SELECT * FROM INVOICE
where customerid = 32;

DELETE FROM InvoiceLine
where invoiceId = 50 or invoiceId = 61 or invoiceId = 116 or invoiceId = 245 or invoiceId = 268 or invoiceId = 290 or invoiceId = 342;

DELETE FROM invoice
where customerid = 32;

DELETE FROM customer
where firstname = 'Robert' AND lastname = 'Walker';
/
--workbook 3.1 System defined functions

--function returns current time
create or replace function
getTime
return timestamp
is 
curr timestamp;
begin
select current_timestamp into curr from dual;
return curr;
end getTime;
/

--function returns media type length
create or replace function
getLength(mId  IN NUMBER)
return number
is
leng number;
begin
SELECT LENGTH(name) INTO leng FROM MEDIATYPE where MEDIATYPEID = mid;
return leng;
end getLength;
/
--workbook 3.2 system defined aggragate functions
create or replace function
avInvoiceTotal
return number
is 
av number (5,2);
begin
select avg(total) into av from invoice;
return av;
end avInvoiceTotal;
/
create or replace function
maxTrack
return number
is 
maxT number (10,2);
begin
select max(unitprice) into maxT from track;
return maxT;
end maxTrack;
/
--workbook 3.3  user defined scalar functions
create or replace function
avInvoicLine
return number
is
avT number;
begin
select avg(unitprice * quantity) into avt from invoiceline;
return avT;
end avInvoicLine;
/

-- Workbook 4.1 Basic Stored procedure
create or replace PROCEDURE
get_e_name
is
r SYS_REFCURSOR;
begin
open r for
select Lastname, firstName from EMPLOYEE;
end get_e_name;
/
execute get_e_name;

--workbook 4.2 input stored procedure
create or replace PROCEDURE
update_employee(id IN NUMBER, ln IN VARCHAR2, fn IN VARCHAR2, a IN VARCHAR2, c IN VARCHAR2, s in VARCHAR2, 
co IN VARCHAR2, pc IN Varchar2, p IN VARCHAR2, f IN VARCHAR2, e IN VARCHAR2)
IS
BEGIN
UPDATE EMPLOYEE
SET LASTNAME = LN, FIRSTNAME = FN, ADDRESS = A, CITY = C,
STATE =S, COUNTRY = CO, POSTALCODE = PC, PHONE = P, FAX = F, EMAIL = E
WHERE EMPLOYEEID = ID;
END update_employee;
/
--test stored procedure
execute update_employee(10,'May','Smith','121 Daimond road','Jewl','TX','USA','44412','555-444-1212','555-444-1233','m.s@yahoo.com');
select * from employee;
/
-- 4.2 continued
create or replace procedure 
get_manager (id  IN NUMBER)
AS
report NUMBER;
efn VARCHAR2 (50);
eln VARCHAR2 (50);
mfn VARCHAR2 (50);
mln VARCHAR2 (50);
BEGIN
SELECT firstName, lastName, reportsTo INTO efn, eln, report FROM employee WHERE employeeID = id;
SELECT firstName, lastName INTO mfn, mln FROM employee WHERE employeeID = report;
SYS.DBMS_OUTPUT.PUT_LINE(mfn || ' ' || mln || ' is the manager of ' || efn || ' ' || eln);
END get_manager;
/
--test procedure

execute get_manager(9);

--worbook 4.3 stored procedure output paramaters
create or replace procedure
get_name_and_c (cid in NUMBER, cn OUT VARCHAR2, CC OUT VARCHAR2)
is
begin
select firstname,company into cn, cc from customer where customerID = cid;
end get_name_and_c;
/

-- workbook 5.0 transactions

create or replace procedure 
delInByID (iId IN number)
is
begin
set transaction name 'delete_invoice';
delete from invoiceline where invoiceid = iId;
delete from invoice where invoiceid = iId;
commit;
end;
/
select * from invoice;
select * from invoiceline where invoiceid = 2;
execute delINBYID(2);

--5.0 continued
create or replace procedure
createCustomer ( fn IN VARCHAR2, ln in varchar2, comp in varchar2, a in varchar2,
ci in varchar2, s in varchar2, cou in varchar2, pc in varchar2, p in varchar2,
f in varchar2, em in varchar2, supId in number)
is
nextPK NUMBER;
eExists VARCHAR2 (100);
cursor c1 is select email from customer where email = em;
begin
set transaction name 'cCustomer';

--finds largest pk and adds by one since they all increment by 1
select max(customerid)+1 into nextPK from customer;

-- check if email exists
open c1;
fetch c1 into eExists;

insert into customer
values(nextPK,fn,ln,comp,a,ci,s,cou,pc,p,f,em,supid);

if c1%found then
  SYS.DBMS_OUTPUT.PUT_LINE('email already taken');
  rollback;
  end if;

close c1;
commit;
end;
/
set serveroutput on;
execute createCustomer('Bob','Rose',null,'fdidjflkj','fdkf','ff','usa','44578','555-987-4547',null,'hi.com',5);

select * from customer;
/
--  6.1 after and for triggers
create or replace trigger employee_inserted
after 
insert on employee
begin
  SYS.DBMS_OUTPUT.PUT_LINE('Row(s) added on employee');
end;
/
create or replace trigger album_update
after 
update on album
begin
  SYS.DBMS_OUTPUT.PUT_LINE('Row(s) updated on album');
end;
/
create or replace trigger customer_delete
after
delete on customer
begin
  SYS.DBMS_OUTPUT.PUT_LINE('Row(s) deleted on customer');
end;
/
--use triggers
set serveroutput on;
insert into employee 
values(200,'h','h','hfdf',6,'12-Dec-1999','12-Dec-2011','ddf','s','ss','jjj','111225','12','12','fgfhg');
delete from employee where employeeid = 200;

select * from album;
update ALBUM set title = 'Balls to the Wall' where albumid = 2;

select * from customer;
delete from customer where customerid = 60;
/
-- 6.2 instead of trigger
create or replace view invoiceView as
select * from invoice;
/
create or replace Trigger deleteInvoice
instead of delete on invoiceView
for each row
declare itotal number := 0;
begin 

select invoiceid into itotal from invoice where invoiceid = :old.invoiceid;

if itotal < 50 then
  delete from invoiceLIne where invoiceid = :old.invoiceid;
  delete from invoice where invoiceid = :old.invoiceid;
end if;

if itotal <= 50 then
  SYS.DBMS_OUTPUT.PUT_LINE('can not delete totals greater than $50 ');
end if;
end;
/

update invoice set total = 55 where invoiceid = 3;
set serveroutput on;
delete from invoiceView where invoiceId = 3;

select * from invoice;
/
-- workbook section 7 joins

-- 7.1 inner join

select invoice.INVOICEID,firstname,lastname
from customer
inner join invoice on customer.customerid = invoice.customerid;
/
-- 7.2 join
select invoice.invoiceid, invoice.total, customer.customerid, firstname, lastname
from customer
join invoice on customer.customerid = invoice.customerid;
/
--right
select title, name
from artist
right join ALBUM on album.artistid = artist.ARTISTID;
--cross
/
select title,artist.NAME from album cross join artist;

--self
SELECT A.firstname AS employee, B.firstname AS manager
FROM employee A, employee B
where a.reportsto = b.employeeid;
/
-- workbook 8.0 indexes
select country from customer;

create cluster invoicecustS (customerID number)
SIZE 512 
STORAGE (initial 100K next 50K);

create index ind_invoicecustS on cluster invoicecusts;

/

create table custONe
cluster invoicecustS (customerID)
as select * from invoice where customerid = 1;

create table custTwo
cluster invoicecustS (customerID)
as select * from invoice where customerid = 2;

/
-- workbook 9 backup
--nothing really descires how to do this clearly