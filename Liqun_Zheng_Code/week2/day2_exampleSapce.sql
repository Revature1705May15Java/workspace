select * from demo_customers;

CREATE SEQUENCE dc_seq -- create sequence of name de_seq
  start with 1000 -- start value
  increment by 5; --increment value
/

CREATE OR REPLACE TRIGGER dc_seq_trigger
BEFORE INSERT ON demo_customers -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN

IF :new.customer_id IS NULL THEN 

  SELECT dc_seq.nextval INTO :new.customer_id FROM DUAL;
  
  END IF;
  
  END;
  /
  
  
  INSERT INTO DEMO_CUSTOMERS
  (cust_first_name, cust_last_name, cust_state, credit_limit, cust_email)
  values('Gen', 'Bon', 'NY', 1000000.00, 'gab12@duke.edu');
  
delete from demo_customers where customer_id = 1005;

alter table demo_customers
add constraint unique_email
 unique(cust_email);
 
 
 select current_date from dual; -- dual 
 
 
 CREATE SEQUENCE do_seq -- create sequence of name de_seq
  start with 100 -- start value
  increment by 100; --increment value
/

CREATE OR REPLACE TRIGGER do_seq_trigger
BEFORE INSERT ON demo_orders -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN

IF :new.order_id IS NULL THEN 

  SELECT do_seq.nextval INTO :new.order_id FROM DUAL;
  
  END IF;


  END;
  /
  
   INSERT INTO DEMO_orders
  (CUSTOMER_ID, ORDER_TOTAL,USER_ID)
  values(1000, 15.1, 200); 
  /
  select * from demo_orders;
  /
  CREATE OR REPLACE TRIGGER do_date_trigger
BEFORE INSERT ON demo_orders -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN
IF :new.order_timestamp IS NULL THEN 
  SELECT current_date INTO :new.order_timestamp FROM DUAL;
  END IF;
  END;
  /
  
  
create or replace procedure
  create_order(c_id IN number, o_t IN number)
is
begin
  insert into demo_orders(customer_id, order_total)
  values(c_id, o_t);
commit;
end create_order;

/

create or replace PROCEDURE
  get_customer(c_id IN number, customer OUT SYS_REFCURSOR)
is 
begin
open customer for
select * from demo_customers where customer_id = c_id;
end get_customer;
/

alter table demo_orders
drop column user_id;
/

insert into demo_orders(customer_id, order_total)
values(1000, 10000);
/

select * from demo_orders;
select * from demo_customers;
/
--
--  INSERT INTO DEMO_CUSTOMERS
--  (cust_first_name, cust_last_name, cust_state, credit_limit, cust_email)
--  values('test', 'test', VA', 1000, 'test');

select * from demo_customers
where customer_id = 1000;
/
call create_order(1015, 153423);
/

update DEMO_CUSTOMERS
set CUST_FIRST_NAME = 'test1', CUST_LAST_NAME = 'test1', CUST_STATE='AZ',
  CREDIT_LIMIT = 100,  CUST_EMAIL= 'test1'
where CUSTOMER_ID = 1015;
/

