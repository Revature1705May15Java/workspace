-- DEMO DDL SCRIPT
/*
Dylan McBee Revature Associate Workbook Assignment

*/

CREATE TABLE DEMO_CUSTOMERS
(
CUSTOMER_ID NUMBER PRIMARY KEY,
CUST_FIRST_NAME VARCHAR2(50) NOT NULL,
CUST_LAST_NAME VARCHAR2(50) NOT NULL,
CUST_STATE VARCHAR2(2CHAR),
CREDIT_LIMIT NUMBER(9,2),
CUST_EMAIL VARCHAR2(100)
);

CREATE TABLE DEMO_ORDERS
(
ORDER_ID NUMBER,
CUSTOMER_ID NUMBER,
ORDER_TOTAL NUMBER(9,2),
ORDER_TIMESTAMP DATE,
USER_ID NUMBER,
PRIMARY KEY(ORDER_ID),
FOREIGN KEY(CUSTOMER_ID) REFERENCES DEMO_CUSTOMERS(CUSTOMER_ID)

);
/
SELECT * FROM DEMO_CUSTOMERS;

CREATE SEQUENCE dc_seq -- create sequence
START WITH 1000 --start value
INCREMENT BY 5;--increment value
/
CREATE OR REPLACE TRIGGER DC_SEQ_TRIGGER
BEFORE INSERT ON DEMO_CUSTOMERS--on what occasion do you want to trigger event
FOR EACH ROW
BEGIN

IF :new.customer_id IS NULL THEN

  SELECT dc_seq.nextval INTO :new.customer_id FROM DUAL;
  
  END IF;
  
END;
  /
  
  INSERT INTO DEMO_CUSTOMERS
  (cust_first_name, cust_last_name, cust_state, credit_limit, cust_email)
  values
  ('DyL', 'McB', 'IN', 1000000.00, 'dhmcbee@gmail.com');
  SELECT * FROM DEMO_CUSTOMERS;
  
/
ALTER TABLE DEMO_CUSTOMERS
ADD CONSTRAINT unique_email
unique(cust_email);
/
CREATE SEQUENCE do_seq -- create sequence
START WITH 1000 --start value
INCREMENT BY 1;--increment value
/
CREATE OR REPLACE TRIGGER DO_SEQ_TRIGGER
BEFORE INSERT ON DEMO_ORDERS--on what occasion do you want to trigger event
FOR EACH ROW
BEGIN

IF :new.order_id IS NULL THEN

  SELECT do_seq.nextval INTO :new.order_id FROM DUAL;
  
  END IF;
  
END;
/
CREATE OR REPLACE TRIGGER DO_DATE_TRIGGER
BEFORE INSERT ON DEMO_ORDERS--on what occasion do you want to trigger event
FOR EACH ROW
BEGIN

IF :new.order_timestamp IS NULL THEN

  SELECT current_date INTO :new.order_timestamp FROM DUAL;
  
  END IF;
  
END;
/
INSERT INTO DEMO_ORDERS
(CUSTOMER_ID, ORDER_TOTAL, USER_ID)
VALUES (1000, 1000, 100);
SELECT * FROM DEMO_ORDERS;
/
CREATE OR REPLACE PROCEDURE
  create_order(c_id IN number, o_t IN number)
is
begin
  insert into demo_orders(customer_id, order_total)
  values(c_id, o_t);
commit;
end create_order;
/
call create_order(1015, 1524.99);
/
CREATE OR REPLACE PROCEDURE
  get_customer(c_id IN number, customer OUT SYS_REFCURSOR)
is
begin
open customer for
select * from demo_customers where customer_id = c_id;
end get_customer;
/
ALTER TABLE DEMO_ORDERS 
DROP COLUMN USER_ID;


insert into demo_orders(customer_id, order_total)
values(1000, 10000);
/
select * from demo_orders;
select * from demo_customers;
/
insert into demo_customers
(cust_first_name, cust_last_name, cust_state, credit_limit, cust_email)
values('test', 'test', 'VA', 1000, 'test');
/
select * from demo_customers
where customer_id = 1000;
/


