/*
  author: Gian-Carlo Barreto
  assignment: BankAccount Project
  purpose: DDL script for creating the Bank database
  date: 25 May 2017
*/

-- Create the User table
CREATE TABLE Bank_User
(
    user_id NUMBER,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    password VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL UNIQUE,
    CONSTRAINT pk_userid PRIMARY KEY (user_id)
);

-- Create the Account Type table
CREATE TABLE Account_Type
(
    type_id NUMBER,
    name VARCHAR2(50),
    CONSTRAINT pk_typeid PRIMARY KEY (type_id)
);

-- Create the Account table
CREATE TABLE ACCOUNT
(
    account_id NUMBER,
    balance NUMBER(12, 2) DEFAULT 0,
    type_id NUMBER NOT NULL,
    open_date DATE NOT NULL,
    close_date DATE,
    CONSTRAINT pk_accountid PRIMARY KEY (account_id),
    CONSTRAINT fk_typeid FOREIGN KEY (type_id) REFERENCES Account_Type(type_id)
);

-- Create junction table named User Account
CREATE TABLE User_Account
(
    user_id NUMBER,
    account_id NUMBER,
    CONSTRAINT pk_joined PRIMARY KEY (user_id, account_id),
    CONSTRAINT fk_userid FOREIGN KEY (user_id) REFERENCES Bank_User(user_id),
    CONSTRAINT fk_accountid FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

/* PL/SQL Commands */
-- Create sequence for User table
CREATE SEQUENCE usr_seq
  START WITH 1000
  INCREMENT BY 5;
/

-- Create sequence for Account table
CREATE SEQUENCE ac_seq
  START WITH 1
  INCREMENT BY 1;
/

-- Create a trigger for the User table
CREATE OR REPLACE TRIGGER usr_seq_trigger
BEFORE INSERT ON Bank_User
FOR EACH ROW
BEGIN
  IF :new.user_id IS NULL THEN
    SELECT usr_seq.nextval INTO :new.user_id FROM DUAL;
  END IF;
END;
/
-- Create a trigger for the Account table
CREATE OR REPLACE TRIGGER ac_seq_trigger
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  IF :new.account_id IS NULL THEN
    SELECT ac_seq.nextval INTO :new.account_id FROM DUAL;
  END IF;
END;
/

-- Create a trigger to input the currect date in the open_date column of the Account table
CREATE OR REPLACE TRIGGER ac_opendate_trigger
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  IF :new.open_date IS NULL THEN
    SELECT CURRENT_TIMESTAMP INTO :new.open_date FROM DUAL;
  END IF;
END;
/

-- Insert values into the Account_Type table
INSERT INTO Account_Type VALUES (1, 'CHECKING');
INSERT INTO Account_Type VALUES (2, 'SAVINGS');
INSERT INTO Account_Type VALUES (3, 'CREDIT');

-- Create a procedure to set the close date of an account
CREATE OR REPLACE PROCEDURE close_account(id IN NUMBER)
  IS
  BEGIN
    UPDATE Account SET close_date = CURRENT_TIMESTAMP WHERE account_id = id;
    COMMIT;
  END close_account;
/