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
/
CREATE SEQUENCE U_SEQ
START WITH 100
INCREMENT BY 5;
/
CREATE SEQUENCE A_SEQ
START WITH 10000
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER U_SEQ_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  IF :NEW.U_ID IS NULL THEN
    SELECT U_SEQ.NEXTVAL INTO :NEW.U_ID FROM DUAL;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER A_SEQ_TRIGGER
BEFORE INSERT ON ACCOUNT
FOR EACH ROW
BEGIN
  IF :NEW.ACCT_ID IS NULL THEN
    SELECT A_SEQ.NEXTVAL INTO :NEW.ACCT_ID FROM DUAL;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER OPEN_DATE_TRIGGER
BEFORE INSERT ON ACCOUNT -- on what occasion do you want ot trigger an event
FOR EACH ROW
BEGIN
  IF :NEW.OPENED IS NULL THEN 
    SELECT current_date INTO :NEW.OPENED FROM DUAL;
  END IF;
END;
/
INSERT INTO USERS(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES('Arthu','Faugue','afaugu','pass');
/
commit;
/
SELECT * FROM USERS WHERE EMAIL = 'afaugue' AND PASSWORD = 'pass';
/
CREATE OR REPLACE PROCEDURE close_acct(id IN NUMBER)
  IS
  BEGIN
    UPDATE Account SET closed = CURRENT_TIMESTAMP WHERE acct_id = id;
  COMMIT;
END close_acct;
/
select closed from account where acct_id = ?;
/
select USER_ACCOUNT.USER_ID, user_account.account_id, account.balance 
from account inner join user_account on user_id = 215;
/

SELECT account.acct_id, account.balance, account.opened, account.closed, accounttype.t_id
                    FROM user_account
                    INNER JOIN users ON user_account.user_id = users.u_id
                    INNER JOIN account ON user_account.account_id = account.acct_id
                    INNER JOIN accounttype ON accounttype.t_id = account.type_id
                    WHERE users.u_Id=215;