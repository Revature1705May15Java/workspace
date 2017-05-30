/*
  James Champ Revature Associate Workbook assignment
*/

-- Section 1: Setting up Oracle Chinook
  -- Chinook database successfully set up.
  
-- Section 2: SQL Queries
-- Problem 2.1.1 : Select all records from the Employee table
SELECT * FROM employee;

-- Problem 2.1.2 : Select all records from the Employee table where last name is King
SELECT * FROM employee
WHERE lastname = 'King';

-- Problem 2.1.3 : Select all records from the Employee table where first name is Andrew
--                 and REPORTSTO is null.
SELECT * FROM employee
WHERE
  firstname = 'Andrew' AND
  reportsto IS NULL;

-- Problem 2.2.1 : Select all albums in Album table and sort result set in descneding order by title.
SELECT * FROM album
ORDER BY title DESC;

-- Problem 2.2.2 : Select first name from Customer and sort result set in ascending order by city.
SELECT firstname FROM customer
ORDER BY city;

-- Problem 2.3.1 : Insert two new records into Genre table.
INSERT INTO genre VALUES (26, 'Spoken Word');
INSERT INTO genre VALUES (27, 'Audio Book');

-- Problem 2.3.2 : Insert two new records into Employee table.
INSERT INTO employee VALUES (9, 'Johnson', 'Robert', 'IT Staff', 6, TO_DATE('1977/02/02', 'yyyy/mm/dd'), CURRENT_DATE, '123 Main St.', 'Lethbridge', 'AB', 'Canada', 'T1H 2Y2', '+1 (403) 467-4324', '+1 (403) 467-1010', 'robert.johnson@chinookcorp.com');
INSERT INTO employee VALUES (10, 'Clark', 'Jason', 'Sales Support Agent', 2, TO_DATE('1983/09/28', 'yyyy/mm/dd'), CURRENT_DATE, '44 Oak St.', 'Calgary', 'AB', 'Canada', '2TP 5N2', '+1 (403) 262-1234', '+1 (403) 262-0001', 'jason@chinookcorp.com');

-- Problem 2.3.3 : Insert two new records into Customer table.
INSERT INTO customer VALUES (60, 'Douglas', 'Times', NULL, '321 Cedar Ln.', 'Paris', 'TX', 'United States of America', '78374', '+1 (740) 223-4930', NULL, 'd.times@yeahio.com', 3);
INSERT INTO customer VALUES (61, 'Lucy', 'Smith', NULL, '2828 NW Willow St.', 'Hope', 'AK', 'United States of America', '34567', '+1 (485) 987-3456', NULL, 'cool.email.bro@coolemail.org', 3);

-- Problem 2.4.1 : Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer c
SET c.firstname = 'Robert',
  c.lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Problem 2.4.2 : Update name of artist in Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE artist a
SET a.name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- Problem 2.5.1 : Select all invoices with a billing address like "T%".
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

-- Problem 2.6.1 : Select all invoices that have a total between 15 and 50.
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

-- Problem 2.6.2 : Select all employees hired between 1 June 2003 and 1 March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN TO_DATE('2003/06/01', 'yyyy/mm/dd') AND TO_DATE('2004/03/01', 'yyyy/mm/dd');

-- Problem 2.7.1 : Delete a record in Customer table where the name is Robert Walter

  -- Change restrictive constraint:
/
ALTER TABLE invoice
  DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice
  ADD CONSTRAINT fk_invoicecustomerid
  FOREIGN KEY (customerid)
  REFERENCES customer(customerid)
  ON DELETE CASCADE;
/  
ALTER TABLE invoiceline
  DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
  ADD CONSTRAINT fk_invoicelineinvoiceid
  FOREIGN KEY (invoiceid)
  REFERENCES invoice(invoiceid)
  ON DELETE CASCADE;
/
  -- Delete cutomer
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
/

-- Section 3 : SQL Functions

-- Problem 3.1.1 : Create a function that returns the current time.
/*
  get_current_time : Returns the current time as a DATE.
*/
CREATE OR REPLACE FUNCTION get_current_time
  RETURN DATE
IS
BEGIN
  RETURN current_timestamp;
END get_current_time;
/

-- Problem 3.1.2 : Create a funtion that returns that length of a mediatype from the mediatype table.
/*
  mediatype_length : Given a mediatypeid, returns the length of that media type's name.
*/
CREATE OR REPLACE FUNCTION mediatype_length
  (type_id IN NUMBER)
  RETURN NUMBER
IS 
  type_length NUMBER;
BEGIN
  SELECT LENGTH(name) 
    INTO type_length 
    FROM mediatype
  WHERE mediatypeid = type_id;
  RETURN type_length;
END mediatype_length;
/

-- Problem 3.2.1 : Create a function that returns the average total of all invoices.
CREATE OR REPLACE FUNCTION ave_invoice_total
  RETURN NUMBER
IS
  invoice_avg NUMBER(10,2);
BEGIN
  SELECT AVG(total)
  INTO invoice_avg
  FROM invoice;
  RETURN invoice_avg;
END ave_invoice_total;
/

-- Problem 3.2.2 : Create a function that returns the most expensive track.
CREATE OR REPLACE FUNCTION most_expensive_track
  RETURN NUMBER
IS
  cost_of_track NUMBER(6,2);
BEGIN
  SELECT MAX(unitprice)
  INTO cost_of_track
  FROM track;
  RETURN cost_of_track;
END most_expensive_track;
/

-- Problem 3.3.1 : Create a function that returns that average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION ave_line_price
  RETURN NUMBER
IS
  ave_line NUMBER(8,2);
BEGIN
  SELECT avg(unitprice)
  INTO ave_line
  FROM invoiceline;
  RETURN ave_line;
END ave_line_price;
/

-- Problem 3.4.1 : Create a function that returns all employees who are born after 1968
CREATE OR REPLACE TYPE emp_row AS OBJECT (
  e_id  NUMBER,
  lname VARCHAR2(20 BYTE),
  fname VARCHAR2(20 BYTE),
  title VARCHAR2(30 BYTE),
  reports_to  NUMBER,
  b_date  DATE,
  h_date  DATE,
  addr  VARCHAR2(70 BYTE),
  city  VARCHAR2(40 BYTE),
  e_state VARCHAR2(40 BYTE),
  country VARCHAR2(40 BYTE),
  postal VARCHAR2(10 BYTE),
  phne  VARCHAR2(24 BYTE),
  fx  VARCHAR2(24 BYTE),
  mail VARCHAR2(60 BYTE)
);
/
CREATE TYPE young_emp_table IS TABLE OF emp_row;

/
CREATE OR REPLACE FUNCTION get_young_employees
  RETURN young_emp_table
AS
  emp_tbl young_emp_table := young_emp_table();
BEGIN
  FOR i in(SELECT * FROM employee WHERE birthdate > TO_DATE('1968/12/31', 'yyyy/mm/dd'))
    LOOP
      emp_tbl.extend;
      emp_tbl(emp_tbl.count) := (emp_row(i.employeeid, i.lastname, i.firstname, i.title, i.reportsto, i.birthdate, i.hiredate, i.address, i.city, i.state, i.country, i.postalcode, i.phone, i.fax, i.email));
    END LOOP;
    RETURN emp_tbl;
END;
/

  -- test:
  -- SELECT * FROM table(get_young_employees);

-- Section 4 : Stored Procedures

-- Problem 4.1.1 : Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE select_names(cur OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cur FOR
    SELECT firstname, lastname 
    FROM employee;
END select_names;
/
-- Problem 4.2.1 : Create a stored procedure that updates the personal information of an employee.
CREATE PROCEDURE update_emp(
  e_id IN NUMBER,
  e_last IN VARCHAR2,
  e_first IN VARCHAR2,
  e_title IN VARCHAR2,
  e_reports IN NUMBER,
  e_bday  IN DATE,
  e_hday  IN DATE,
  e_addr  IN VARCHAR2,
  e_city  IN VARCHAR2,
  e_state IN VARCHAR2,
  e_country IN VARCHAR2,
  e_pcode IN VARCHAR2,
  e_phone IN VARCHAR2,
  e_fax IN VARCHAR2,
  e_email IN VARCHAR2)
IS
BEGIN
  UPDATE employee
  SET
    lastname = e_last,
    firstname = e_first,
    title = e_title,
    reportsto = e_reports,
    birthdate = e_bday,
    hiredate = e_hday,
    address = e_addr,
    city = e_city,
    state = e_state,
    country = e_country,
    postalcode = e_pcode,
    phone = e_phone,
    fax = e_fax,
    email = e_email
  WHERE employeeid = e_id;
END update_emp;
/             

-- Problem 4.2.2 : Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_managers(emp_id IN NUMBER, man_cur OUT SYS_REFCURSOR)
IS
  boss_id NUMBER;
BEGIN
  SELECT reportsto
  INTO boss_id
  FROM employee
  WHERE employeeid = emp_id;
  
  OPEN man_cur FOR
  
  SELECT *
  FROM employee
  WHERE employeeid = boss_id;
END get_managers;

/

-- Problem 4.3.1 : Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_cust_info(c_id IN NUMBER, s_cur OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN s_cur FOR
  SELECT firstname, lastname, company
  FROM customer
  WHERE customerid = c_id;
END get_cust_info;
/
-- Section 5 : Transactions

-- Problem 5.1.1 : Create a transaction that, given an invoiceid, will delete that invoice.
SET TRANSACTION NAME 'delete_invoice';

CREATE OR REPLACE PROCEDURE delete_inv(i_id IN NUMBER) 
IS
BEGIN
  SAVEPOINT A;
  DELETE FROM invoice
  WHERE invoiceid = i_id;
  
  COMMIT;
END delete_inv;
/
  -- Test:
  -- CALL delete_inv(412);

-- Problem 5.1.2 : Create a transaction nested within a stored procedure that inserts a new record in the Customer table.
SET TRANSACTION NAME 'insert_new_customer';
CREATE OR REPLACE PROCEDURE ins_new_cust(
  c_id IN NUMBER,
  c_fname IN VARCHAR2,
  c_lname IN VARCHAR2,
  c_company IN VARCHAR2,
  c_addr  IN VARCHAR2,
  c_city  IN VARCHAR2,
  c_state IN VARCHAR2,
  c_country IN VARCHAR2,
  c_pcode IN VARCHAR2,
  c_phone IN VARCHAR2,
  c_fax IN VARCHAR2,
  c_email IN VARCHAR2,
  c_support_id  IN NUMBER)
IS
BEGIN
  SAVEPOINT A;
  INSERT INTO customer 
  VALUES (
    c_id,
    c_fname,
    c_lname,
    c_company,
    c_addr,
    c_city,
    c_state,
    c_country,
    c_pcode,
    c_phone,
    c_fax,
    c_email,
    c_support_id);
    
    COMMIT;
END ins_new_cust;
/
  -- Test:
  -- CALL ins_new_cust(62, 'Fake', 'Name', null, '123 Street St.', 'Anytown', 'PA', 'United States of America', '48484', '1 (393) 555-5555', null, 'fake.email@fake.com', 3);

-- Section 6 : Triggers

-- Problem 6.1.1 : Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER new_emp_added_alert
  AFTER INSERT ON employee
  FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('New employee added.'); 
END;
/

-- Problem 6.1.2 : Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER new_album_added_alert
  AFTER INSERT ON album
  FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('New album added.');
END;
/

-- Problem 6.1.3 : Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER cust_deleted_alert
  AFTER DELETE ON customer
  FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('Customer deleted from customers table.');
END;
/

-- Problem 6.2.1 : Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE VIEW invoice_view AS
  SELECT * 
  FROM invoice;
/
CREATE OR REPLACE TRIGGER halt_exp_deletion
  INSTEAD OF DELETE ON invoice_view
  FOR EACH ROW
BEGIN
  IF :old.total <= 50 THEN
    DELETE FROM invoice WHERE invoice.invoiceid = :old.invoiceid;
  END IF;
END;
/

-- Section 7 : Joins

-- Problem 7.1.1 : Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid = invoice.customerid;
/

-- Problem 7.2.1 : Create an outer join that joins the customer and invoice table, specifying the customerid, firstname, lastname, invoiceid, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;
/

-- Problem 7.3.1 : Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album
RIGHT OUTER JOIN artist
ON artist.artistid = album.artistid;
/

-- Problem 7.4.1 : Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album
CROSS JOIN artist
ORDER BY artist.name;
/

-- Problem 7.5.1 : Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.*, b.*
FROM employee a, employee b
WHERE a.employeeid = b.reportsto;
/

-- Section 8 : Indexes

-- Problem 8.1.1 : Create a clustered index on [a] table of your choice.
CREATE CLUSTER cust_lname(lname VARCHAR2(20 BYTE));
/
CREATE INDEX cust_lname_index
  ON CLUSTER cust_lname;
/
-- Section 9 : Administration

-- Problem 9.1.1 : Create a .bak file for the Chinook database.
/*
  Goto:
    1. Tools -> Database Export
    2. Select "Chinook" from connections drop-down
    3. Enter filepath in "File:" text box
    4. Click "Next" button four times
    5. Click "Finish" button
*/