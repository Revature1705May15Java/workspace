--DCL for examples
--create user examples
--identified by p4ssw0rd;
--
--grant connect to examples;
--grant resource to examples;

--DDL demo
/*
Eric Christie Revature Associate Workbook assignment
*/
-- Section 1
-- Problem 1.1: write script to do x
/
drop table demo_order;
drop table demo_customer;
/
create table demo_customer (
customer_id number primary key,
cust_first_name varchar2(50) not null,
cust_last_name varchar2(50) not null,
cust_addressline1 varchar2(80),
cust_addressline2 varchar2(80),
cust_state varchar2(2 char),
credit_limit number(9,2),
cust_email varchar2(100)
);
/
create table demo_order (
order_id number,
customer_id number not null,
order_total number(9,2),
order_timestamp date,
user_id number,
primary key(order_id),
foreign key(customer_id) references demo_customer(customer_id)
);
/
alter table demo_customer
add constraint unique_email
unique (cust_email);
/
alter table demo_order
drop column user_id;
/
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'one', 'one@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='one@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'two', 'two@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='two@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'three', 'three@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='three@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'four', 'four@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='four@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'five', 'five@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='five@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'six', 'six@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='six@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'seven', 'seven@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='seven@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'eight', 'eight@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='eight@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'nine', 'nine@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='nine@email.com'), 100.00);
insert into demo_customer(cust_first_name, cust_last_name, cust_email)
values ('customer', 'ten', 'ten@email.com');
insert into demo_order(customer_id, order_total)
values ((select customer_id from demo_customer where cust_email='ten@email.com'), 100.00);
/
drop if exists sequence dc_seq;
create sequence dc_seq
start with 1
increment by 1;
/
drop sequence do_seq;
create sequence do_seq
start with 1
increment by 1;
/
create or replace trigger dc_seq_trigger
before insert on demo_customer
for each row
begin
  if :new.customer_id is null then
    select dc_seq.nextval into :new.customer_id from dual;
  end if;
end;
/
create or replace trigger do_seq_trigger
before insert on demo_order
for each row
begin
  if :new.order_id is null then
    select do_seq.nextval into :new.order_id from dual;
  end if;
  if :new.order_timestamp is null then
    select current_timestamp into :new.order_timestamp from dual;
  end if;
end;
/
select * from demo_customer;
select * from demo_order;
/
create or replace procedure
  create_order(c_id in number, o_t in number)
is
begin
  insert into demo_order(customer_id, order_total) values (c_id, o_t);
commit;
end;
/
create or replace procedure
  get_customer(c_id in number, customer out sys_refcursor)
is
begin
  open customer for
  select * from demo_customer where customer_id=c_id;
end get_customer;
/
call create_order(8, 2329.00); -- THIS IS HOW YOU USE A STORED PROCEDURE