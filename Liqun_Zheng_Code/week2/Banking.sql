
--Create tables
CREATE TABLE Users
(
    U_ID NUMBER,
    First_Name VARCHAR2(100) NOT NULL,
    Last_Name VARCHAR2(100) NOT NULL,
    username VARCHAR2(100) NOT NULL UNIQUE,
    Password VARCHAR2(50)NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY  (U_ID)
);

CREATE TABLE Account
(
    Acc_Id NUMBER,
    Balance NUMBER(12,2) DEFAULT 0.0,
    Type_ID NUMBER NOT NULL,
    Opened DATE NOT NULL,
    Closed DATE,
    
    CONSTRAINT PK_Account PRIMARY KEY  (Acc_Id),
    CONSTRAINT FK_Acc_type FOREIGN KEY  (Type_ID) REFERENCES AccountType(T_id)
);


CREATE TABLE User_Account
(
    User_Id NUMBER,
    Account_Id NUMBER,
    
    CONSTRAINT PK_Joined PRIMARY KEY  (User_Id, Account_id),
    CONSTRAINT FK_User FOREIGN KEY  (User_Id) References users(u_id),
    CONSTRAINT FK_account FOREIGN KEY  (Account_Id) References account(acc_id)
);

CREATE TABLE AccountType
(
    T_Id NUMBER,
    Type_name varchar2(50),
    
    CONSTRAINT PK_UserAccount PRIMARY KEY  (t_Id)
  
);
/

/*
Add values to lookup table.
DML Script
*/

insert into accounttype values(1, 'Checking');
insert into accounttype values(2, 'Saving');
insert into accounttype values(3, 'Credit');
select * from accounttype;

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
if:new.u_id is null then 
  select u_seq.nextval into :new.u_id from dual;
  end if;
  end;
  /
  
CREATE OR REPLACE TRIGGER a_seq_trigger
before insert on account
for each row 
begin 
if:new.acc_id is null then 
  select a_seq.nextval into :new.acc_id from dual;
  end if;
  end;
  /
  
/*
TEST DML Scripts for JDBC statements
*/

  insert into users(first_name, last_name, password, username)
  values('G', 'B', 'password', 'gb@uname.com');
  /
  
  select * from users where lower(username) = 'test';
