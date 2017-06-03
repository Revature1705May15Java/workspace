-- DCL
DROP USER ers CASCADE;

CREATE USER ers
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO ers;
GRANT RESOURCE TO ers;
GRANT CREATE SESSION TO ers;
GRANT CREATE TABLE TO ers;
GRANT CREATE VIEW TO ers;

CONN ers/p4ssw0rd;


-- DDL
CREATE TABLE users (
  userId   NUMBER PRIMARY KEY,
  email    VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  fName    VARCHAR(100) NOT NULL,
  lName    VARCHAR(100) NOT NULL,
  isManager NUMBER DEFAULT 0 CHECK (isManager BETWEEN 0 AND 1)
);

CREATE TABLE requestStateType (
  typeId NUMBER PRIMARY KEY,
  name   VARCHAR(50)
);

CREATE TABLE request (
  requestId NUMBER PRIMARY KEY,
  requesterId NUMBER NOT NULL REFERENCES users(userId),
  handlerId NUMBER REFERENCES users(userId),
  stateTypeId NUMBER REFERENCES requestStateType(typeId),
  amount NUMBER(12, 2) CHECK (amount > 0.0),
  purpose VARCHAR2(140) NOT NULL,
  note VARCHAR2(140),
  dateRequested DATE DEFAULT sysdate,
  dateHandled DATE
);

/

CREATE SEQUENCE userSeq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER userSeqTrg
BEFORE INSERT ON users
FOR EACH ROW
  BEGIN
    IF INSERTING AND :new.userId IS NULL
    THEN
      SELECT userSeq.nextval
      INTO :new.userId
      FROM dual;
    END IF;
  END;
/

CREATE SEQUENCE requestSeq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER requestSeqTrg
BEFORE INSERT ON request
FOR EACH ROW
  BEGIN
    IF INSERTING AND :new.requestId IS NULL
    THEN
      SELECT requestSeq.nextval
      INTO :new.requestId
      FROM dual;
    END IF;
  END;
/


COMMIT;
EXIT;