CREATE SEQUENCE e_seq
start with 100
increment by 1;
/
CREATE OR REPLACE TRIGGER e_seq_trigger
before insert on employee
for each row
begin
if :new.employee_id is null then
  select e_seq.nextval into :new.employee_id from dual;
  end if;
  end;
/
INSERT INTO EMPLOYEE(email, password, first_name, last_name, is_manager)
values('test@test.com', 'test', 'test', 'test', 1);
/
INSERT INTO EMPLOYEE(email, password, first_name, last_name, is_manager)
values('teste@test.com', 'teste', 'teste', 'teste', 0);
/
CREATE SEQUENCE r_seq
start with 1
increment by 1;
/
create or replace TRIGGER r_seq_trigger
before insert on requests
for each row
begin
if :new.request_id is null then
  select r_seq.nextval into :new.request_id from dual;
  end if;
  end;
/
commit;
/
rollback;
/

insert into state_type(state_id,state_name)
values(3, 'Denied');
/

INSERT INTO requests(amount, purpose, requestor_id)
values(100.00, 'stuff', 101);
/
select * from requests;
select * from employee;
/
UPDATE EMPLOYEE SET FIRST_NAME = 'testemp', LAST_NAME = 'testemp' 
WHERE EMPLOYEE_ID = 101;
/
-- Create a procedure to resolve a request
CREATE OR REPLACE PROCEDURE resolve_request(id IN NUMBER, state IN NUMBER, manager IN NUMBER)
  IS
  BEGIN
    UPDATE Requests SET state_id = state, date_resolved = CURRENT_TIMESTAMP, resolver_id = manager WHERE request_id = id;
    COMMIT;
  END resolve_request;
/
commit;