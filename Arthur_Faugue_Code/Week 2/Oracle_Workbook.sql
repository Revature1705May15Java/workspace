/*
Revature Associate SQL Workbook
Author: Arthur Faugue
*/
--Part I � Working with an existing database

--2.1 SELECT
--Task � Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
/
--Task � Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
/
--Task � Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO is NULL;
/
--2.2 ORDER BY
--Task � Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
/
--Task � Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME, CITY FROM CUSTOMER
ORDER BY CITY ASC;
/
--2.3 INSERT INTO
--Task � Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'EDM');
/
INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Anime');
/
--Task � Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO,
BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE,
FAX, EMAIL)
VALUES (9, 'Zimmer', 'Glint', 'Sales Manager', 2, '27-FEB-71', '27-FEB-11', 
'123 Street', 'City', 'GA', 'USA', 32025, '678-554-5146', '444-158-0525',
'zimmerman@c.com');
/
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO,
BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE,
FAX, EMAIL)
VALUES (10, 'Guy', 'Man', 'Sales Manager', 6, '26-FEB-71', '26-FEB-11', 
'123 Street', 'City', 'GA', 'USA', 32025, '678-544-5146', '244-158-0525',
'guyman@c.com');
/
--Task � Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS,
CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Guy', 'Man', 'S.Manager', '123 Street', 'City', 'GA', 
'USA', 32025, '678-544-5146', '244-158-0525', 'guyman@c.com', 3); 
/
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS,
CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (65, 'Aaron', 'Mitchell', 'S.Mana', '123 Street', 'City', 'GA', 
'USA', 32025, '678-544-7146', '244-158-0527', 'guyan@c.com', 3);
/
--2.4 UPDATE
--Task � Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/
--Task � Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
--2.5 LIKE
--Task � Select all invoices with a billing address like �T%�
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6 BETWEEN
--Task � Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 20;
/
--Task � Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '1-MAR-04';
/
--2.7 DELETE
--Task � Delete a record in Customer table where the name is Robert Walter 
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
/
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;
/
ALTER TABLE INVOICE 
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID) ON DELETE CASCADE;
/
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE (INVOICEID) ON DELETE CASCADE;
/
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/


--3.0 SQL FUNCTIONS
--3.1 SYSTEM DEFINED FUNCTIONS
--Task � Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP
IS
BEGIN
  RETURN CURRENT_TIMESTAMP;
END;
/
--Task � create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION GET_LENGTH(MEDIA_ID IN NUMBER)
RETURN NUMBER
IS TEMP NUMBER;
BEGIN
  SELECT LENGTH(MEDIATYPE.NAME) INTO TEMP
  FROM MEDIATYPE WHERE MEDIATYPEID = MEDIA_ID;
  RETURN TEMP;
END;
/
--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--Task � Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVG_INVOICE
RETURN NUMBER
IS TEMP NUMBER;
BEGIN
  SELECT AVG(TOTAL) INTO TEMP FROM INVOICE;
  RETURN TEMP;
END;
/
--Task � Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MAX_PRICE
RETURN NUMBER
IS M_PRICE NUMBER(9,2);
BEGIN
  SELECT MAX(UNITPRICE) INTO M_PRICE
  FROM TRACK;
  RETURN M_PRICE;
END;
/
--3.3 USER DEFINED SCALAR FUNCTIONS
--Task � Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INV_PRICE
RETURN NUMBER 
IS TEMP NUMBER;
BEGIN
  SELECT AVG(UNITPRICE) INTO TEMP
  FROM INVOICELINE;
  RETURN TEMP;
END;
/
--3.4 USER DEFINED TABLE VALUES FUNCTIONS
--Task � Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE NEST_EMPLOYEE AS OBJECT(
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
  POSTALCODE VARCHAR2(10),
  PHONE VARCHAR2(24),
  FAX VARCHAR2(24),
  EMAIL VARCHAR2(60)
);
/
CREATE OR REPLACE TYPE NESTED_TABLE AS TABLE OF NEST_EMPLOYEE;
/
CREATE OR REPLACE FUNCTION AFTER_YEAR
RETURN NESTED_TABLE PIPELINED
IS
BEGIN
  FOR I IN (
    SELECT * FROM EMPLOYEE
    WHERE EMPLOYEE.BIRTHDATE < '01-JAN-1968') 
    LOOP
      PIPE ROW (NEST_EMPLOYEE(I.EMPLOYEEID, I.LASTNAME, I.FIRSTNAME, I.TITLE, I.REPORTSTO,
      I.BIRTHDATE, I.HIREDATE, I.ADDRESS, I.CITY, I.STATE, I.COUNTRY, I.POSTALCODE, 
      I.PHONE, I.FAX, I.EMAIL));
    END LOOP;
  RETURN;
END;
/


--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURES
--Task � Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FULL_NAME(EMP OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN EMP FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END FULL_NAME;
/
--4.2 STORED PROCEDURES INPUT PARAMETERS
--Task � Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_INFO(EID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2, EM IN VARCHAR2)
IS
BEGIN
  UPDATE EMPLOYEE
  SET EMPLOYEE.EMPLOYEEID = EID, EMPLOYEE.FIRSTNAME = FN, EMPLOYEE.LASTNAME = LN, EMPLOYEE.EMAIL = EM;
END;
/
--Task � Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE FUNCTION RETURN_BOSS(EID NUMBER)
RETURN NUMBER
IS TEMP NUMBER;
BEGIN
  SELECT REPORTSTO INTO TEMP
  FROM EMPLOYEE WHERE EMPLOYEEID = EID;
  RETURN TEMP;
END;
/
CREATE OR REPLACE PROCEDURE MY_MANAGER(EID IN NUMBER)
IS TEMP NUMBER;
BEGIN
  TEMP := RETURN_BOSS(EID);
  DBMS_OUTPUT.PUT('EMPLOYEEID OF BOSS IS ');
  DBMS_OUTPUT.PUT_LINE(TEMP);
END;
/
--4.3 STORED PROCEDURES OUTPUT PARAMETERS
--Task � Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMP_CUST(CUST_ID IN NUMBER, NAME OUT VARCHAR2, COMPANY OUT VARCHAR2)
IS
BEGIN
  SELECT (LASTNAME || ', ' || FIRSTNAME), COMPANY
  INTO NAME, COMPANY
  FROM CUSTOMER WHERE CUSTOMERID = CUST_ID;
END NAME_COMP_CUST;
/


--5.0 TRANSACTIONS
--Task � Create a transaction that given a invoiceId will delete that invoice 
CREATE OR REPLACE PROCEDURE DEL_INVOICE(IN_ID IN NUMBER)
IS
BEGIN
  SAVEPOINT SAVE_THIS;
  DELETE FROM INVOICE
  WHERE INVOICEID = IN_ID;
  EXCEPTION
  WHEN OTHERS THEN
  ROLLBACK TO SAVE_THIS;
  RAISE;
END DEL_INVOICE;
/
--Task � Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE TRIGGER CUST_SEQ_TRIGGER
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
BEGIN
  IF:NEW.CUSTOMERID IS NULL THEN 
    SELECT CUST_SEQ.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
  END IF;
END;
/
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(FNAME IN VARCHAR2, LNAME IN VARCHAR2, E_MAIL IN VARCHAR2)
IS
BEGIN
  SAVEPOINT INSERT_SAVE;
  INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL) VALUES (FNAME, LNAME, E_MAIL);
  EXCEPTION
  WHEN OTHERS THEN
  ROLLBACK TO INSERT_SAVE;
  RAISE;
END INSERT_CUSTOMER;
/


--6.0 TRIGGERS
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER INSRT_IN_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('INSERTED INTO EMPLOYEE');
END;
/
--Task � Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER INSRT_ROW_UPDATE
AFTER INSERT ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('INSERTED INTO ALBUM');
END;
/
--Task � Create an after delete trigger on the customer table that fires after a row is deleted frGom the table.
CREATE OR REPLACE TRIGGER DELT_ROW_UPDATE
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
      DBMS_OUTPUT.PUT_LINE('DELETE');
END;
/
--6.2 INSTEAD OF 
--Task � Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE VIEW VIEW_ALL 
AS SELECT * FROM INVOICE;
/
CREATE OR REPLACE TRIGGER NO_DELETE
INSTEAD OF DELETE ON VIEW_ALL
FOR EACH ROW
BEGIN
  IF :NEW.TOTAL > 50 THEN
    DBMS_OUTPUT.PUT_LINE('OVER 50');
  END IF;
END;
/


--7.0 JOINS
--7.1 INNER
--Task � Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT DISTINCT INVOICE.CUSTOMERID, CUSTOMER.FIRSTNAME,
  INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;
/
--7.2 OUTER
--Task � Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT INVOICE.CUSTOMERID, CUSTOMER.FIRSTNAME,
  CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;
/
--7.3 RIGHT
--Task � Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT * FROM ARTIST
RIGHT OUTER JOIN ALBUM ON ALBUM.ARTISTID = ARTIST.ARTISTID;
/
--7.4 CROSS
--Task � Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ARTIST
CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC;
/
--7.5 SELF
--Task � Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.EMPLOYEEID = EMPLOYEE.REPORTSTO;
/


--8.0 INDEXES
--8.1 CLUSTERED INDEXES
--Task � Create a clustered index on of table of your choice
CREATE CLUSTER CLUST_ALBUM
   (ARTISTNAME VARCHAR(100))
SIZE 512 
STORAGE (initial 100K next 50K);
/
CREATE INDEX ALBUM_INDEX
ON CLUSTER CLUST_ALBUM;
/
--9.0 ADMINISTRATION
-- The bak file will be included with the sql file.