--DDL Bank Script
CREATE TABLE AccountType
(
	t_id NUMBER,
	type_name VARCHAR2(50),
	CONSTRAINT PK_AType PRIMARY KEY (t_id)

);

CREATE TABLE Account
(
	acct_Id NUMBER PRIMARY KEY,
	balance NUMBER(12,2) DEFAULT 0.0,
	type_id NUMBER NOT NULL,
	opened DATE NOT NULL,
	closed DATE,
	CONSTRAINT FK_acct_type FOREIGN KEY (type_id) REFERENCES AccountType (t_id)
	

);

CREATE TABLE Users
(

	u_id NUMBER PRIMARY KEY,
	first_name VARCHAR2(100) NOT NULL,
	last_name VARCHAR2(1000) NOT NULL,
	password VARCHAR2(50) NOT NULL,
	username VARCHAR2(100) NOT NULL UNIQUE


);

CREATE TABLE User_Account
(
  User_Id NUMBER,
  Account_Id NUMBER,
  CONSTRAINT PK_joined PRIMARY KEY(user_id, account_id),
  CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES USERS(u_id),
  CONSTRAINT FK_account FOREIGN KEY (account_id) REFERENCES ACCOUNT(acct_id)

);

/*
Add values to lookup table
DML Script
*/

INSERT INTO ACCOUNTTYPE VALUES(1, 'Checking');
INSERT INTO ACCOUNTTYPE VALUES(2, 'Savings');
INSERT INTO ACCOUNTTYPE VALUES(3, 'Credit');
SELECT * FROM ACCOUNTTYPE;

/*
PL/SQL block for triggers & sequences
*/
CREATE SEQUENCE u_seq
start with 100
increment by 5;
/
CREATE SEQUENCE a_seq
start with 10000
increment by 1;
/
CREATE OR REPLACE TRIGGER u_seq_trigger
before insert on users
for each row
begin
if :new.u_id is null then
  select u_seq.nextval into :new.u_id from dual;
  end if;
  end;
  /
CREATE OR REPLACE TRIGGER a_seq_trigger
before insert on account
for each row
begin
if :new.acct_id is null then
  select a_seq.nextval into :new.acct_id from dual;
  end if;
  end;
/

/*
TEST DML Scripts for JDBC statements
*/

INSERT INTO USERS(first_name, last_name, password, username)
values('D', 'M', 'password', 'dm@uname.com');
/
select * from users;
/
CREATE OR REPLACE TRIGGER ACCT_DATE_TRIGGER
BEFORE INSERT ON ACCOUNT--on what occasion do you want to trigger event
FOR EACH ROW
BEGIN

IF :new.OPENED IS NULL THEN

  SELECT current_date INTO :new.OPENED FROM DUAL;
  
  END IF;
  
END;
/
CREATE OR REPLACE PROCEDURE close_account(id IN NUMBER)
  IS
  BEGIN
    UPDATE Account SET closed = CURRENT_TIMESTAMP WHERE acct_id = id;
    COMMIT;
  END close_account;