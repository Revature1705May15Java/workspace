/*
  author: Gian-Carlo Barreto
  assignment: Revatute Associate SQL Workbook Oracle 11g
*/

/* 2.0 SQL Queries
   In this section you will be performing various queries against the Oracle Chinook database.
*/

/* 2.1 SELECT */
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee
WHERE lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

/* 2.2 ORDER BY */
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album
ORDER BY title DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer
ORDER BY city ASC;

/* 2.3 INSERT INTO */
-- Task – Insert two new records into Genre table
INSERT INTO Genre (genreid, name) VALUES (26, 'Korean Pop');
INSERT INTO Genre (genreid, name) VALUES (27, 'Folk Rock');

-- Task – Insert two new records into Employee table
INSERT INTO Employee VALUES (9, 'Doe', 'John', 'Software Engineer', NULL, '01-May-93', SYSDATE, '123 Frying Pan Rd.', 'Herndon', 'VA', 'USA', '84753', '(352) 984-3843', NULL, 'johndoe@gmail.com');
INSERT INTO Employee VALUES (10, 'Doe', 'Jane', 'Stripper', NULL, '01-May-93', SYSDATE, '123 Frying Pan Rd.', 'Herndon', 'VA', 'USA', '84753', '(352) 984-3843', NULL, 'janedoe@gmail.com');

-- Task – Insert two new records into Customer table
select * from customer;
INSERT INTO Customer VALUES (60, 'John', 'Doe', 'Revature', '123 Frying Pan Rd.', 'Herndon', 'VA', 'USA', '84753', '(352) 984-3843', NULL, 'johndoe@gmail.com', 1);
INSERT INTO Customer VALUES (61, 'Jane', 'Doe', 'Papermoon', '123 Frying Pan Rd.', 'Herndon', 'VA', 'USA', '84753', '(352) 984-3843', NULL, 'janedoe@gmail.com', 1);

/* 2.4 UPDATE */
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron'
AND lastname = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

/* 2.5 LIKE */
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE billingaddress LIKE 'T%';

/* 2.6 BETWEEN */
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice
WHERE total BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

/* 2.7 DELETE */
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE Invoice
DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE Invoice
ADD CONSTRAINT fk_invoicecustomerid
FOREIGN KEY (customerid) REFERENCES Customer(customerid)
ON DELETE CASCADE;

ALTER TABLE Invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE Invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid
FOREIGN KEY (invoiceid) REFERENCES Invoice(invoiceid)
ON DELETE CASCADE;

DELETE FROM Customer
WHERE lastname = 'Walter';

/* 3.0 SQL Functions */
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

/* 3.1 System Defined Functions */
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
  RETURN VARCHAR2
  IS current_time VARCHAR2(20);
  BEGIN
    SELECT TO_CHAR(SYSTIMESTAMP, 'HH24:MI:SS')
    INTO current_time
    FROM DUAL;
    RETURN current_time;
  END;
/

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_length(id IN NUMBER)
  RETURN NUMBER
  IS length NUMBER;
  BEGIN
    SELECT LENGTH(name)
    INTO length
    FROM Mediatype
    WHERE mediatypeid = id;
    RETURN length;
  END;
/

/* 3.2 System Defined Aggregate Functions */
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_avg
  RETURN NUMBER
  IS average NUMBER;
  BEGIN
    SELECT AVG(total)
    INTO average
    FROM Invoice;
    RETURN average;
  END;
/

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_max
  RETURN NUMBER
  IS max_price NUMBER;
  BEGIN
    SELECT MAX(unitprice)
    INTO max_price
    FROM Track;
    RETURN max_price;
  END;
/

/* 3.3 User Defined Scalar Functions */
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_invoice_price
  RETURN NUMBER
  IS average NUMBER;
  BEGIN
    SELECT AVG(unitprice)
    INTO average
    FROM Invoiceline;
    RETURN average;
  END;
  /
  
  /* 3.4 User Defined Table Valued Functions */
  -- Task – Create a function that returns all employees who are born after 1968.
  CREATE OR REPLACE FUNCTION get_emp
    RETURN SYS_REFCURSOR
    AS st_cursor SYS_REFCURSOR;
    BEGIN
      OPEN st_cursor FOR
      SELECT * FROM Employee WHERE birthdate >= '01-JAN-69';
      RETURN st_cursor;
    END get_emp;
  /

/* 4.0 Stored Procedures */
-- In this section you will be creating and executing stored procedures. 
-- You will be creating various types of stored procedures that take input and output parameters.

/* 4.1 Basic Stored Procedure */
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_emp_name(employees OUT SYS_REFCURSOR)
  IS
  BEGIN
    OPEN employees FOR
    SELECT firstname, lastname FROM Employee;
  END get_emp_name;
/
variable rc refcursor;
exec get_emp_name( :rc );
print rc;

/* 4.2 Stored Procedure Input Parameters */
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployee (e_id number, e_ln varchar2, e_fn varchar2, e_address varchar2, e_city varchar2, e_state varchar2, 
  e_country varchar2, e_postalcode varchar2, e_phone varchar2, e_fax varchar2, e_email varchar2)
  IS
  BEGIN
    UPDATE Employee
    SET lastname = e_ln, firstname = e_fn, address = e_address, city = e_city, state = e_state, country = e_country, postalcode = e_postalcode, phone = e_phone, fax = e_fax, email = e_email
    WHERE employeeid = e_id;
  END updateEmployee;
/

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getManager (id IN NUMBER, manager OUT NUMBER)
  IS
  BEGIN
    SELECT reportsto
    INTO manager
    FROM Employee
    WHERE employeeid = id;
  END getManager;
/

/* 4.3 Stored Procedure Output Parameters */
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE getInfo(id IN NUMBER, fn OUT VARCHAR2, ln OUT VARCHAR2, c OUT VARCHAR2)
  IS
  BEGIN
    SELECT firstname, lastname, company
    INTO fn, ln, c
    FROM Customer
    WHERE customerid = id;
  END getInfo;
/

/* 5.0 Transactions */
/* In this section you will be working with transactions. 
   Transactions are usually nested within a stored procedure. 
   You will also be working with handling errors in your SQL.
*/
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
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

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE createCustomer(id IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2, com IN VARCHAR2, a IN VARCHAR2, c IN VARCHAR2, s IN VARCHAR2,
    cnt IN VARCHAR2, pc IN VARCHAR2, p IN VARCHAR2, f IN VARCHAR2, e IN VARCHAR2, sid IN NUMBER)
  IS
  BEGIN
    SAVEPOINT start_tran;
    INSERT INTO Customer 
    VALUES (id, fn, ln, com, a, c, s, cnt, pc, p, f, e, sid);
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK TO start_tran;
    RAISE;
  END;
/

/* 6.0 Triggers */
/* In this section you will create various kinds of triggers that work when certain DML statements are executed on a table. */

/* 6.1 AFTER/FOR */
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER em_after_trigger
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
  dbms_output.put_line('Did something');
END;
/

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER al_after_trigger
AFTER UPDATE ON Album
FOR EACH ROW
BEGIN
  dbms_output.put_line('Did something else');
END;
/

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER cus_after_trigger
AFTER DELETE ON Customer
FOR EACH ROW
BEGIN
  dbms_output.put_line('Row Deleted');
END;
/

/* 6.2 INSTEAD OF */
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
/*

  Need to do this one still.

*/

/* 7.0 JOINS */
/* In this section you will be working with combing various tables through the use of joins. 
   You will work with outer, inner, right, left, cross, and self joins.
*/

/* 7.1 INNER */
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname AS "First Name", c.lastname AS "Last Name", i.invoiceid AS "Invoice ID"
FROM Customer c
INNER JOIN Invoice i ON c.customerid = i.customerid; 

/* 7.2 OUTER */
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid AS "Custommer ID", c.firstname AS "First Name", c.lastname AS "Last Name", i.invoiceid AS "Invoice ID", i.total AS "Total"
FROM Customer c
FULL OUTER JOIN Invoice i ON c.customerid = i.customerid; 

/* 7.3 RIGHT */
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name AS "Name", al.title AS "Title"
FROM Album al
RIGHT JOIN Artist art ON al.artistid = art.artistid; 

/* 7.4 CROSS */
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM Album al
CROSS JOIN Artist art
ORDER BY art.name ASC;

/* 7.5 SELF */
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.firstname AS "Emp First Name", e1.lastname AS "Emp Last Name", e2.firstname AS "Supervisor First Name", e2.lastname AS "Supervisor Last Name"
FROM Employee e1, Employee e2
WHERE e1.reportsto = e2.employeeid;

/* 8.0 Indexes */
/* In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data. */

/* 8.1 Clustered Indexes */
-- Task – Create a clustered index on of table of your choice

/* 9.0 Administration */
/* In this section you will be creating backup files of your database. 
   After you create the backup file you will also restore the database.
*/
-- Task – Create a .bak file for the Chinook database.
