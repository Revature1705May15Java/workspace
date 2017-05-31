/*
 * Create tables for BankingApp
 * DDL Script
 */

-- Lookup table
create table accountType (
  id number primary key,
  name varchar2(20) unique not null--,
--  interestRate number not null -- only include this if interestRate is determined solely by accountType
);
/
create table bankUser (
	id number primary key,
--	SSN number unique not null, -- is there a way to verify a user's ssn?
	email varchar2(50) unique not null, -- try to implement validation and verification
	passwordHash varchar2(100) not null,
	firstname varchar2(100) not null,
	lastname varchar2(100) not null--,
--  joinDate date not null--,
--	birthdate date,
--	streetAddress varchar2(80),
--	city varchar2(40),
--	state varchar2(2),
--	zipcode varchar2(10),
--	phone varchar2(10)
);
/
create table account (
	id number primary key,
	typeid number not null,
  balance number(12,2) default 0.00, -- default to 0
	openDate date not null,-- default current_date, -- default to current_date/current_timestamp
	closeDate date,
	constraint FK_accountType foreign key(typeid) references accountType(id)
);
/
create table accountHolder ( -- only allow one user to be connected to six open accounts
	accountId number not null,
	accountHolderId number not null,
  linkDate date not null,
  unlinkDate date,
	constraint PK_account_holder primary key(accountId, accountHolderId),
	constraint FK_user foreign key(accountHolderId) references bankUser(id),
	constraint FK_account foreign key(accountId) references account(id)
);
/
/*
 * Add values to lookup table.
 * DML Script
 */
insert into accountType values (1, 'savings');
insert into accountType values (2, 'checking');
insert into accountType values (3, 'credit');
/
/*
 * PL/SQL block for triggers and sequences
 */
create sequence bankUser_seq
start with 1
increment by 1;
/
create sequence account_seq
start with 1
increment by 1;
/
-- this trigger should set joinDate to current date
create or replace trigger bankUser_trigger
before insert on bankUser for each row
begin
	if :new.id is null then
	 select bankUser_seq.nextval into :new.id from dual;
	end if;
end;
/
create or replace trigger account_trigger
before insert on account for each row
begin
  if :new.id is null then
   select account_seq.nextval into :new.id from dual;
  end if;
  if :new.openDate is null then
    select current_date into :new.openDate from dual;
  end if;
end;
/
create or replace trigger accountHolder_insert_trigger
before insert on accountHolder for each row
declare openAccountCount number;
activeAccountHolderCount number;
begin
  select count(*) into openAccountCount from account a, accountHolder ah
  where ah.accountholderid=:new.accountholderid and a.id=ah.accountid and (a.closeDate is null or a.closeDate > current_date);
  select count(*) into activeAccountHolderCount from accountHolder ah
  where ah.accountid=:new.accountid and (ah.unlinkDate is null or ah.unlinkDate > current_date);
  if openAccountCount >= 6 or activeAccountHolderCount >= 4 then
    -- do something to cancel the operation
    rollback;
  elsif :new.linkDate is null then
    select current_date into :new.linkDate from dual;
  end if;
end;
/
create or replace trigger accountHolder_update_trigger
before update on accountHolder for each row
declare activeAccountHolderCount number;
begin
  select count(*) into activeAccountHolderCount from accountHolder h
  where h.accountid=:old.accountid and (h.unlinkDate is null or h.unlinkDate > current_date);
  if activeAccountHolderCount < 2 then
    -- do something to cancel the operation
    rollback;
  end if;
end;
/
create or replace function transfer_money(from_id number, to_id number, amount number) return boolean
is answer boolean;
row_count1 number;
row_count2 number;
begin
  savepoint before_transfer;
  update account set balance=(select balance from account where id=from_id)-amount where id=from_id;
  row_count1 := sql%rowcount;
  if row_count1 = 1 then
    update account set balance=(select balance from account where id=to_id)+amount where id=to_id;
    row_count2 := sql%rowcount;
    if row_count2 = 1 then
      answer := true;
    else
      rollback to savepoint before_transfer;
      answer := false;
    end if;
  else
    rollback to savepoint before_transfer;
    answer := false;
  end if;
  return answer;
exception
  when others then
    rollback to savepoint before_transfer;
    answer := false;
    return answer;
end;
/
create or replace function check_password_hash(eml varchar2, pHash varchar2) return boolean
is storedPasswordHash varchar2(50);
begin
  select u.passwordHash into storedPasswordHash from bankUser u where u.email=eml;
  return pHash=storedPasswordHash;
end;