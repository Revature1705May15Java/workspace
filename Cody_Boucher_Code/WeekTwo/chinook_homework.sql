--Chinook SQL Homework

--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
/

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;
/

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
/

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
/

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE(GENREID, NAME) VALUES(100, 'Heavy Metal');
/
INSERT INTO GENRE(GENREID, NAME) VALUES(101, 'Country');
/

--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9, 'Johnson', 'Mick', 'Sales', 7, '03-Mar-94', '01-Jan-14', '123 Street street', 'Tempe', 'AZ', 'United States', 'T3K 8Y1', '+1 (453) 134-7456', '+1 (245) 743-9674', 'mick@chinookcorp.com');
/
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(10, 'Hales', 'Ashley', 'Sales', 7, '05-Jan-98', '03-APR-15', '456 Avenue street', 'Bozeman', 'MT', 'United States', 'T6L 3D1', '+1 (453) 648-1937', '+1 (245) 523-8132', 'ashley@chinookcorp.com');
/

--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(60, 'Amanda', 'Smith', null, '13 Street Road', 'Miami', 'FL', 'United States', 84325, '1 642-832-6281', null, 'asmith@email.com', 5);
/
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(61, 'Houston', 'Rickson', null, '1st Street block', 'Atlanta', 'GA', 'United States', 58394, '1 543-691-7732', null, 'hrockson@email.com', 3);
/

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
/

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; 
/

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY(CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'; 
/
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

SELECT TO_CHAR (SYSDATE, 'HH24:MI:SS') "NOW" FROM DUAL NOW; --not a function
/
CREATE FUNCTION currentTime RETURN TIMESTAMP
IS
BEGIN
  RETURN currentTime;
END;
/
--Task – create a function that returns the length of a mediatype from the mediatype table
--3.2 System Defined Aggregate Functions
select * from mediatype;
SELECT LENGTH(NAME) FROM MEDIATYPE; --not a function
/
CREATE FUNCTION lengthMediaType(ID NUMBER)
RETURN NUMBER
IS
mediaLength NUMBER;
BEGIN
  SELECT LENGTH(NAME) FROM MEDIATYPE WHERE MEDIATYPEID = ID;
  RETURN mediaLength;
end;
/

--Task – Create a function that returns the average total of all invoices
CREATE FUNCTION getAverage
RETURN NUMBER 
IS 
averageTotal NUMBER;
BEGIN
  select AVG(TOTAL) INTO averageTotal FROM INVOICE;
  RETURN averageTotal;
END;
/

--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;
/
CREATE FUNCTION mostExpensive
RETURN NUMBER
IS
price NUMBER;
BEGIN
  SELECT MAX(UNITPRICE) INTO price FROM TRACK;
  RETURN price;
END;
/

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE FUNCTION averagePrice
RETURN NUMBER
IS
price NUMBER;
BEGIN
  SELECT AVG(UNITPRICE) INTO price FROM INVOICELINE;
  RETURN price;
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= '01-JAN-69'; --QUERY
/

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE PROCEDURE getNames(sys_cur out SYS_REFCURSOR)
IS
BEGIN
  OPEN sys_cur FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE PROCEDURE updateInformation(empId NUMBER, newPhone VARCHAR2, newEmail VARCHAR2)
AS
BEGIN
  UPDATE EMPLOYEE SET EMIAL = newEmail, PHONE = newPhone WHERE EMPLOYEEID = empId;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.

CREATE PROCEDURE getManager(empId IN NUMBER, empManager out EMPLOYEE_TYPE)
AS
BEGIN
  SELECT EMPLOYEE_TYPE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
  INTO empManager FROM EMPLOYEE WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = empId);
  RETURN;
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE PROCEDURE customerInfo(custId IN NUMBER)
IS
BEGIN
  SELECT FIRSTNAME, LASTNAME FROM CUSTOMER WHERE CUSTOMERID = custId;
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace TRIGGER afterTrigger
AFTER INSERT on EMPLOYEE
BEGIN
  dbms_output.put_line('employee added');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TRIGGER afterUpdate
AFTER UPDATE on ALBUM
BEGIN
  dbms_output.put_line('album updated');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE TRIGGER afterDelete
AFTER DELETE on CUSTOMER
BEGIN
  dbms_output.put_line('customer deleted');
END;
/

--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUS.FIRSTNAME as "Customer first name", CUS.LASTNAME as "Customer Last name", INV.INVOICEID as "Invoice ID"
FROM INVOICE INV
INNER JOIN CUSTOMER CUS ON CUS.CUSTOMERID = INV.INVOICEID;
/

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUS.CUSTOMERID AS "Customer ID", CUS.FIRSTNAME as "Customer first name", CUS.LASTNAME as "Customer Last name", INV.INVOICEID as "Invoice ID",INV.TOTAL as "Total"
FROM INVOICE INV
FULL OUTER JOIN CUSTOMER CUS ON CUS.CUSTOMERID = INV.INVOICEID;
/

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT AL.TITLE as "Album Title", ART.NAME as "Artist Name"
FROM ALBUM AL
RIGHT JOIN ARTIST ART ON ART.ARTISTID = AL.ARTISTID;
/

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ARTIST cross join ALBUM ORDER BY ARTIST.NAME ASC;
/

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.EMPLOYEEID, b.REPORTSTO FROM EMPLOYEE a, EMPLOYEE b WHERE a.EMPLOYEEID = b.REPORTSTO;
/

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE CLUSTER artistCluster(ARTISTID NUMBER);
/
CREATE INDEX artistId on CLUSTER artistCluster;

--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database.



