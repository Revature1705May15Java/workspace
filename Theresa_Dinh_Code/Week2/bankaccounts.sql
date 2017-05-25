CREATE USER bankuser  
IDENTIFIED BY pass
-- DEFAULT TABLESPACE Userperson

GRANT connect to bankuser; 
GRANT resource to bankuser; 
-- GRANT CREATE SESSION TO bankuser; 
-- GRANT CREATE TB bankuser; 
-- GRANT crate view TO bankuser
//////////////////////////////////////////////////////////////////////////
-- Create all the tables 
CREATE TABLE AccountType
(   
    TypeId NUMBER, 
    TypeName VARCHAR(50),
    CONSTRAINT PK_AccountType PRIMARY KEY (TypeId)
); 
CREATE TABLE Account
(  
    AccountId NUMBER, 
    Balance NUMBER(12,2) DEFAULT 0.00, 
    TypeId NUMBER NOT NULL, 
    OpenDate DATE NOT NULL, 
    CloseDate DATE, 
    CONSTRAINT PK_Account PRIMARY KEY (AccountId),
    CONSTRAINT FK_AccountTypeId FOREIGN KEY (TypeId) REFERENCES AccountType (TypeId)
); 
CREATE TABLE Users
(
    UserId NUMBER NOT NULL,
    FName VARCHAR2(100) NOT NULL,
    LName VARCHAR2(100) NOT NULL,
    Password VARCHAR2(100) NOT NULL, 
    Email VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_UserId PRIMARY KEY (UserId)
); 
CREATE TABLE UserAccount
(
    UserId NUMBER,
    AccountId NUMBER, 
    CONSTRAINT PK_CompositeID PRIMARY KEY (UserId, AccountId),
    CONSTRAINT FK_UserAccount FOREIGN KEY (UserId) REFERENCES Users(UserId),
    CONSTRAINT FK_Account FOREIGN KEY (AccountId) REFERENCES Account(AccountId)
); 
/////////////////////////////////////////////////////////////////////////////////////////////
-- adding values to lookup table
INSERT INTO AccountType 
VALUES (1, 'Checking'); 
INSERT INTO ACCOUNTTYPE VALUES(2, 'SAVINGS'); 
INSERT INTO ACCOUNTTYPE VALUES(3, 'CREDIT'); 
SELECT * FROM ACCOUNTTYPE; 
/
-- SEQUENCES AND TRIGGERS 
CREATE SEQUENCE UserSeq
START WITH 100
INCREMENT BY 5; 
/
CREATE SEQUENCE AccountSeq
START WITH 10000
INCREMENT BY 1; 
/
CREATE OR REPLACE TRIGGER UserSeqTrigger
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN 
IF :new.USERID IS NULL THEN 
SELECT USERSEQ.NEXTVAL INTO :NEW.USERID FROM DUAL; 
END IF;
END; 
/ 
CREATE OR REPLACE TRIGGER AccSeqTrigger
BEFORE INSERT ON Account 
FOR EACH ROW 
BEGIN 
IF :new.accountid IS NULL THEN 
SELECT AccountSEQ.NEXTVAL INTO :NEW.accountid FROM DUAL; 
END IF;
END; 
/

