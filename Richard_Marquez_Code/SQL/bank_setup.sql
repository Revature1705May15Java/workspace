-- DCL
DROP USER bank CASCADE;

CREATE USER bank
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO bank;
GRANT RESOURCE TO bank;
GRANT CREATE SESSION TO bank;
GRANT CREATE TABLE TO bank;
GRANT CREATE VIEW TO bank;

CONN bank/p4ssw0rd;

-- DDL
CREATE TABLE banker (
  userid   NUMBER PRIMARY KEY,
  fname    VARCHAR(100) NOT NULL,
  lname    VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email    VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE accounttype (
  typeid NUMBER PRIMARY KEY,
  name   VARCHAR(50)
);

CREATE TABLE bankaccount (
  accountid NUMBER PRIMARY KEY,
  balance   NUMBER(12, 2) DEFAULT 0.0,
  typeid    NUMBER NOT NULL,
  opened    DATE          DEFAULT sysdate,
  closed    DATE,
  CONSTRAINT fk_accounttype FOREIGN KEY (typeid) REFERENCES accounttype (typeid)
);

CREATE TABLE bankeraccount (
  userid    NUMBER,
  accountid NUMBER,
  CONSTRAINT pk_bankeraccount PRIMARY KEY (userid, accountid),
  CONSTRAINT fk_user FOREIGN KEY (userid) REFERENCES banker (userid),
  CONSTRAINT fk_account FOREIGN KEY (accountid) REFERENCES account (accountid)
);


/

-- banker auto-increment
CREATE SEQUENCE banker_seq
START WITH 1
INCREMENT BY 1;


/
CREATE OR REPLACE TRIGGER banker_seq_trg
BEFORE INSERT ON banker
FOR EACH ROW
  BEGIN
    IF INSERTING AND :new.userid IS NULL
    THEN
      SELECT banker_seq.nextval
      INTO :new.userid
      FROM dual;
    END IF;
  END;
/

-- bankaccount auto-increment
CREATE SEQUENCE account_seq
START WITH 1
INCREMENT BY 1;


/
CREATE OR REPLACE TRIGGER account_seq_trg
BEFORE INSERT ON account
FOR EACH ROW
  BEGIN
    IF INSERTING AND :new.accountid IS NULL
    THEN
      SELECT account_seq.nextval
      INTO :new.accountid
      FROM dual;
    END IF;
  END;
/

SELECT *
FROM banker;

CREATE OR REPLACE PROCEDURE transferFunds(fromId IN NUMBER, toId IN NUMBER, amt IN NUMBER)
IS
  fromOldBal NUMBER;
  fromNewBal NUMBER;
  toOldBal   NUMBER;
  toNewBal   NUMBER;
  BEGIN
    SAVEPOINT transferTransaction;

    SELECT balance
    INTO fromOldBal
    FROM account
    WHERE accountid = fromId;
    SELECT balance
    INTO toOldBal
    FROM account
    WHERE accountid = toId;

    fromNewBal := fromOldBal - amt;
    toNewBal := toOldBal + amt;

    UPDATE account
    SET balance = fromNewBal
    WHERE account.accountid = fromId;

    UPDATE account
    SET balance = toNewBal
    WHERE account.accountid = toId;

    COMMIT;

    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK TO transferTransaction;
    RAISE;
  END transferFunds;
/

CREATE OR REPLACE FUNCTION getNumAccounts(uId IN NUMBER)
  RETURN NUMBER
IS
  numAccounts NUMBER;
  BEGIN

    SELECT count(*)
    INTO numAccounts
    FROM account
    WHERE accountId IN
          (SELECT accountId
           FROM bankerAccount
           WHERE userId = uId)
          AND closed IS NULL;
    RETURN numAccounts;
  END;
/

COMMIT;
EXIT;