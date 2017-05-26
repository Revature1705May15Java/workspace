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
	username varchar2(30) unique not null,
	email varchar2(50) unique not null, -- try to implement validation and verification
	password varchar2(50) encrypt using 'AES256' identified by some_password 'SHA-1' salt not null,
      -- alternative encryption algorithms: 'AES128', 'AES192', '3DES168'
      -- encrypt passwords (they should not be stored in plain text) 
	firstname varchar2(100) not null,
	lastname varchar2(100) not null,
  joinDate date not null,
	birthdate date,
	streetAddress varchar2(80),
	city varchar2(40),
	state varchar2(2),
	zipcode varchar2(10),
	phone varchar2(10)
);
/
create table account (
	id number primary key,
	typeid number not null,
  balance number(12,2) default 0.00, -- default to 0
	openDate date not null default current_date, -- default to current_date/current_timestamp
	closeDate date,
	constraint FK_accountType foreign key(typeid) references accountType(id)
);
/
create table accountHolder ( -- only allow one user to be connected to six open accounts
	accountId number not null,
	accountHolderId number not null,
	constraint PK_account_holder primary key(accountId, accountHolderId),
	constraint FK_user foreign key(accountHolderId) references bankUser(id),
	constraint FK_account foreign key(accountId) references account(id)
);
/
-- logging of transactions and other stuff will probably be done via some other tool

--create table transaction (); 
--create table transactionType ();

/*
 * Add values to lookup table.
 * DML Script
 */
insert into accountType values (1, 'savings');
insert into accountType values (1, 'checking');
insert into accountType values (1, 'credit');
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
  if :new.
end;
/
-- this trigger should also set the openDate to the current date?
create or replace trigger account_trigger
before insert on account for each row
begin
  if :new.accountNumber is null then
   select account_seq.nextval into :new.accountNumber from dual;
  end if;
end;
/
