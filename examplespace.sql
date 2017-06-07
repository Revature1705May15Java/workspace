-- dummy DDL script

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

PRIMARY KEY (ORDER_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES DEMO_CUSTOMERS(CUSTOMER_ID)
);

/









SELECT * FROM demo_customers;

CREATE SEQUENCE dc_seq 
START WITH 10000 INCREMENT BY 5;
/
CREATE OR REPLACE TRIGGER dc_seq_trigger --creating the trigger
BEFORE INSERT ON demo_customers --on what occasion do you want to trigger an event?
FOR EACH ROW
BEGIN
  IF :new.customer_ID IS NULL THEN
    SELECT dc_seq.nextval INTO :new.customer_id FROM DUAL; -- dual is a dummy DB
  END IF;
END;
/





INSERT INTO DEMO_CUSTOMERS(cust_first_name,cust_last_name,cust_state,credit_limit,cust_email)
VALUES ('Genesis','Bonds', 'VA', 1000000.00,'reallyrealemail@email.com');
/
SELECT * FROM DEMO_CUSTOMERS;
/
ALTER TABLE DEMO_CUSTOMERS
ADD CONSTRAINT unique_email
unique(cust_email);
/
DELETE FROM DEMO_CUSTOMERS where customer_id = 10005;
/
SELECT current_date FROM dual;
/

-- Create our own sequence and trigger for the demo_orders
SELECT * FROM demo_orders;

CREATE SEQUENCE do_seq 
START WITH 10000 INCREMENT BY 5;
/
CREATE OR REPLACE TRIGGER do_seq_trigger --creating the trigger
BEFORE INSERT ON demo_orders --on what occasion do you want to trigger an event?
FOR EACH ROW
BEGIN
  IF :new.order_ID IS NULL THEN
    SELECT do_seq.nextval INTO :new.order_id FROM DUAL; -- dual is a dummy DB
  END IF;
END;
/
CREATE OR REPLACE TRIGGER do_date_trigger --creating the trigger
BEFORE INSERT ON demo_orders --on what occasion do you want to trigger an event?
FOR EACH ROW
BEGIN
  IF :new.order_timestamp IS NULL THEN
    SELECT current_date INTO :new.order_timestamp FROM DUAL; -- dual is a dummy DB
  END IF;
END;
/
INSERT INTO demo_orders(customer_ID, order_total, user_id)
VALUES(10000, 1000,100);
/
SELECT * FROM demo_orders;
/



CREATE OR REPLACE PROCEDURE
  create_order(c_id IN NUMBER, o_t IN NUMBER)
IS
BEGIN
  INSERT INTO demo_orders(customer_id, order_total)
  VALUES(c_id, o_t);
COMMIT; -- information is not persisted if you don't do this
END create_order;
/

CREATE OR REPLACE PROCEDURE
  get_customer(c_id IN NUMBER, customer OUT SYS_REFCURSOR)
IS
BEGIN
OPEN customer FOR
SELECT * FROM demo_customers WHERE customer_id = c_id;
END get_customer;
/

INSERT INTO demo_orders(customer_id, order_total)
VALUES(10000, 10000);
/
SELECT * FROM demo_orders;
/
SELECT * FROM demo_customers;
/
CALL create_order (10020, 12911);
/












