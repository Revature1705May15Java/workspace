CREATE USER bank
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bank;
GRANT resource to bank;
GRANT create session TO bank;
GRANT create table TO bank;
GRANT create view TO bank;



conn bank/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE User
(
    UserID NUMBER,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    Email VARCHAR2(40) NOT NULL UNIQUE,
    Password VARCHAR2(40)NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY  (UserID)
);

CREATE TABLE Account
(
    AccountId NUMBER NOT NULL,
    Balance NUMBER(30,2) DEFAULT 0,
    TypeID NUMBER NOT NULL,
    OpenDate DATE NOT NULL,
    CloseDate DATE,
    
    CONSTRAINT PK_Account PRIMARY KEY  (AccountId),
    CONSTRAINT FK_Account FOREIGN KEY  (TypeID) REFERENCES AccountType(Typeid)
);


CREATE TABLE UserAccount
(
    UserId NUMBER,
    AccountId NUMBER,
    
    CONSTRAINT PK_UserAccount PRIMARY KEY  (UserId),
    CONSTRAINT FK_UserAccount FOREIGN KEY  (UserId) References user(userid),
    CONSTRAINT PK_UserAccount PRIMARY KEY  (AccountId),
    CONSTRAINT FK_UserAccount FOREIGN KEY  (AccountId) References account(accountid)
);

CREATE TABLE AccountType
(
    TypeId NUMBER,
    AccountName varchar2(50),
    
    CONSTRAINT PK_UserAccount PRIMARY KEY  (TypeId)
  
);
