/*
Eric Christie Revature Associate Workbook assignment
*/
-- Part I
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task - Select all records from the Employee table.
select * from employee;
--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname='King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname='Andrew' and reportsto is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;
--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
insert into genre(genreid, name) values (26, 'Indie');
insert into genre(genreid, name) values (27, 'Foreign');
--Task – Insert two new records into Employee table
insert into employee(employeeid, firstname, lastname) values (9, 'john', 'doe');
insert into employee(employeeid, firstname, lastname) values (10, 'jane', 'doe');
--Task – Insert two new records into Customer table
insert into customer(customerid, firstname, lastname, email) values (60, 'john', 'doe', 'jd@email.com');
insert into customer(customerid, firstname, lastname, email) values (61, 'jane', 'doe', 'jd@gmail.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname='Robert', lastname='Walter'
where firstname='Aaron' and lastname='Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set name='CCR' where name='Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employees where hiredate between '01-JUN-03' and '01-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table invoice drop constraint FK_InvoiceCustomerId;
alter table invoice add constraint FK_InvoiceCustomerId foreign key(customerId) references customer(customerId) on delete cascade;
alter table invoiceline drop constraint FK_INVOICELINEINVOICEID;
alter table invoiceline add constraint FK_INVOICELINEINVOICEID foreign key(invoiceid) references invoice(invoiceid) on delete cascade;
delete from customer where firstname='Robert' and lastname='Walter';
/
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace function what_time_it_is return timestamp
is
begin
  return current_timestamp;
end;
/
--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function mediatype_length(id number) return number
is answer number;
begin
  select length(name) into answer from mediatype where mediatypeid=id;
  return answer;
end;
/
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
create or replace function get_average_total
return number is val number(10,2);
begin
  select avg(total) into val from invoice;
  return val;
end;
/
--Task – Create a function that returns the most expensive track
create or replace function get_overpriced_track return varchar2
is trackname varchar2(200);
maxprice number(10,2);
begin
  select name into trackname from track where unitprice=(select max(unitprice) from track);
  return(trackname);
end;
/
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function get_average_price return number
is average_price number(10,2);
begin
  select avg(unitprice) into average_price from invoiceline;
  return average_price;
end;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create or replace type employee_type as object
(
EMPLOYEEID NUMBER,
LASTNAME VARCHAR2(20),
FIRSTNAME VARCHAR2(20),
TITLE VARCHAR2(30),
REPORTSTO NUMBER,
BIRTHDATE DATE,
HIREDATE DATE,
ADDRESS VARCHAR2(70),
CITY VARCHAR2(40),
STATE VARCHAR2(40),
COUNTRY VARCHAR2(40),
OSTALCODE VARCHAR2(10),
PHONE VARCHAR2(24),
FAX VARCHAR2(24),
EMAIL VARCHAR2(60)
);
/
create or replace type employee_table as table of employee_type;
/
create or replace function get_employees_born_before (dateInYear date) return employee_table
pipelined is
begin
  for i in (select employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,
            address, city, state, country, postalcode, phone, fax, email from employee
            where birthdate < trunc(dateInYear, 'YEAR')) loop
    pipe row (employee_type(i.employeeid, i.lastname, i.firstname, i.title, i.reportsto, i.birthdate, i.hiredate, i.address, i.city,
              i.state, i.country, i.postalcode, i.phone, i.fax, i.email));
  end loop;
  return;
end;
/
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace type fullname_type as object (fname varchar2(20), lname varchar2(20));
/
create or replace type fullname_table as table of fullname_type;
/
create or replace procedure get_names(names out fullname_table) as
begin
  select fullname_type(firstname, lastname) bulk collect into names from employee;
  return;
end;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure set_employee_email(e_id number, newEmail varchar2) as
begin
  update employee set email=newEmail where employeeid=e_id;
end;
/
--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure get_manager(e_id in number, e_manager out employee_type) as
begin
  select employee_type(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state,
  country, postalcode, phone, fax, email) 
  into e_manager from employee where employeeid=(select reportsto from employee where employeeid=e_id);
  return;
end;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure get_customer_name_and_company
(c_id in number, fname out customer.firstname%type, customer_company out customer.company%type) as
begin
  select firstname, company into fname, customer_company from customer where customerid=c_id;
  return;
end;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure delete_invoice(inv_id in number) as
begin
  set transaction name 'delete_invoice_transaction';
  delete from invoice where invoiceid=inv_id;
  commit work;
exception
  when others then
    rollback;
    raise;
end;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure add_customer
(c_id in number, fname in varchar2, lname in varchar2, email in varchar2) as
begin
  set transaction name 'new_customer_transaction';
  insert into customer (customerid, firstname, lastname, email) values (c_id, fname, lname, email);
  commit work;
exception
  when others then
    rollback;
    raise;
end;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger added_employee_trigger
after insert on employee for each row
declare ex exception;
begin
  if :new.email is null then
    raise ex;
  end if;
end;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger updated_album_trigger
after update of artistid on album for each row
declare album_count number;
begin
  select count(*) into album_count from album where album.artistid=:old.artistid;
  if album_count=0 then
    delete from artist where artist.artistid=:old.artistid;
  end if;
end;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger removed_customer_trigger
after delete on customer for each row
begin
  delete from invoiceline where invoiceline.invoiceid in (select invoiceid from invoice inv where inv.customerid=:old.customerid);
  delete from invoice where invoice.customerid=:old.customerid;
end;
/
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create or replace view invoice_view as select * from invoice;
/
create or replace trigger invoice_removal_trigger
instead of delete on invoice_view for each row
begin
  if :old.total <= 50.00 then
    delete from invoice where invoiceid=:old.invoiceid;
  end if;
end;
/
insert into invoice (invoiceid, customerid, invoicedate, total) values (413, 61, current_date, 100.00);
select count(*) from invoice;
select * from invoice where invoiceid=413;
delete from invoice_view where invoiceid=413;
select count(*) from invoice;
select * from invoice where invoiceid=413;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select cus.firstname, cus.lastname, inv.invoiceid from customer cus inner join invoice inv on cus.customerid=inv.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select cus.customerid, cus.firstname, cus.lastname, inv.invoiceid, inv.total
from customer cus full outer join invoice inv on cus.customerid=inv.invoiceid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select art.name, alb.title from artist art right outer join album alb on art.artistid=alb.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album, artist order by artist.name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select * from employee emp, employee man where emp.reportsto=man.employeeid;
/
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on a table of your choice
create cluster track_cluster (genreid number sort);
/
create index track_index on cluster track_cluster sort;
/
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database.
create flashback archive default fbArchive tablespace some_tablespace retention 1 day;
/
create restore point my_restore_point;
/
flashback database to restore point my_restore_point;
-- Alternatively you could use rman from the command prompt:
-- > rman
-- RMAN > backup database;