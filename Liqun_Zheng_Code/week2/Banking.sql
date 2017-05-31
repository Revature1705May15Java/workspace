
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

commit;
/
  CREATE OR REPLACE TRIGGER open_date_trigger
BEFORE INSERT ON account -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN
IF :new.opened IS NULL THEN 
  SELECT current_date INTO :new.opened FROM DUAL;
  END IF;
  END;
  /
  
  create sequence acc_id_seq
  start with 100 
  increment by 10;
  /
  
  CREATE OR REPLACE TRIGGER acc_id_trigger
BEFORE INSERT ON account -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN
IF :new.acc_id IS NULL THEN 
  SELECT acc_id_seq.nextval INTO :new.acc_id FROM DUAL;
  END IF;
  END;
  /
  
--  INSERT INTO account(type_id) VALUES(1) RETURNING acc_id INTO word;
--create procedure insert_acc_pro(type_id in number, acc_id out number)
--as 
--begin 
CREATE or replace FUNCTION get_recent_accid
  return number
  is 
  accid number;
  begin
    select max(acc_id) 
    into accid
    from ACCOUNT;
    return accid;
  END;
  /
  
 CREATE or replace FUNCTION get_recent_userid
  return number
  is 
  userid number;
  begin
    select max(u_id) 
    into userid
    from users;
    return userid;
  END;
  / 
  
 select get_recent_accid() from dual;
 /
INSERT INTO account (type_id) VALUES (1);

select max(acc_id) from account;
commit;

insert into user_account values(100,100);

select * from account where acc_id = 100;

select type_name from accounttype where t_id = 1;


select* 
from account
where ACC_ID in (select account_id
from user_account
where user_id = 100);
/

select* from Users where U_ID in (select USER_id
					from user_account where ACCOUNT_id = 100);
          /
          
   UPDATE account
    SET balance = 0
    WHERE acc_id = 100;
    
    
create or replace function get_num_accounts (u_id IN Number)
    return number 
    is
    num_accounts number;
    
    cursor c1 is 
     select count(*) from account where ACC_ID IN
    (select account_id from user_account where USER_ID = u_id)
    AND CLOSED is NULL;
    
    begin 
    
    open c1;
    fetch c1 into num_accounts;
    
    if c1%notfound then 
      num_accounts :=0;
    end if;
    
    close c1;
    
    return num_accounts;
    end;
    
  /
  
select get_num_accounts(100) from dual;
  /
  
  CREATE OR REPLACE PROCEDURE close_acc(id IN NUMBER)
  IS
  BEGIN
    UPDATE Account SET closed = CURRENT_TIMESTAMP WHERE acc_id = id;
    COMMIT;
  END close_acc;
  
  /
  commit;
  
  SELECT account.acc_id, account.balance, account.opened, account.closed, accounttype.t_id
                    FROM user_account
                    INNER JOIN users ON user_account.user_id = users.u_id
                    INNER JOIN account ON user_account.account_id = account.acc_id
                    INNER JOIN accounttype ON accounttype.t_id = account.type_id
                    WHERE users.u_Id=105;