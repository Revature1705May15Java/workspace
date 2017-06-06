/*
 * Create tables for Employee Reimbursement System
 * DDL Script
 */
create table requestState (
  id number primary key,
  name varchar2(30) unique not null
);
/
create table employee (
  id number primary key,
  email varchar2(100) unique not null,
  passwordHash varchar2(100) not null,
  firstname varchar2(100) not null,
  lastname varchar2(100) not null,
  isManager int not null check (isManager in (0,1)),
  emailAlertsOn int not null check (emailAlertsOn in (0,1)),
  latestLogout timestamp
);
/
create table request (
  id number primary key,
  stateId number not null references requestState(id),
  requesterId number not null references employee(id),
  resolverId number references employee(id),
  amount number(12,2) not null check (amount>0.00),
  requestedTimestamp timestamp not null,
  resolvedTimestamp timestamp,
  purpose varchar2(140), --140 characters, because twitter
  note varchar2(140) --140 characters, because twitter
);
/
/*
 * Add values to lookup table.
 * DML Script
 */
insert into requestState values (1, 'pending');
insert into requestState values (2, 'approved');
insert into requestState values (3, 'denied');
/
/*
 * PL/SQL block for triggers and sequences
 */
create sequence employee_seq
start with 1
increment by 1;
/
create sequence request_seq
start with 1
increment by 1;
/
create or replace trigger insert_employee
before insert on employee for each row
begin
  if :new.id is null then
    select employee_seq.nextval into :new.id from dual;
  end if;
  if :new.emailAlertsOn is null and :new.isManager=0 then
    select 1 into :new.emailAlertsOn from dual;
  else
    select 0 into :new.emailAlertsOn from dual;
  end if;
end;
/
create or replace trigger insert_request
before insert on request for each row
begin
  if :new.id is null then
    select request_seq.nextval into :new.id from dual;
  end if;
  if :new.stateId is null then
    select rs.id into :new.stateId from requestState rs where lower(rs.name)='pending';
  end if;
  if :new.requestedTimestamp is null then
    select localtimestamp into :new.requestedTimestamp from dual;
  end if;
end;
/
create or replace trigger update_request
before update on request for each row --request records should only be updated when they are resolved
begin
  if :new.resolvedTimestamp is null then
    select localtimestamp into :new.resolvedTimestamp from dual;
  end if;
end;
/
/*
 * Add the first manager to the database.
 * DML Script
 */
insert into employee (email, passwordHash, firstname, lastname, isManager)
values ('admin@email.com', 'sha1:64000:18:1fel5lyvOdM65X1+WiZKbgsAyxS4Lhlu:MiR8H/VvDX3jAI6YnH9fEeXN', 'ADMIN', 'USER', 1);