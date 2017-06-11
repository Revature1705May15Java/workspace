CREATE USER refundDB
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO refundDB;
GRANT RESOURCE TO refundDB;
/
/*
isBoss 
0=regular employee
1=boss
*/
CREATE TABLE USER_E
(
U_ID NUMBER NOT NULL,
EMAIL VARCHAR(50) NOT NULL UNIQUE,
PASSWRD VARCHAR(50) NOT NULL,
FIRSTNAME VARCHAR(25) NOT NULL,
LASTNAME VARCHAR(25) NOT NULL,
ISBOSS NUMBER NOT NULL,
CONSTRAINT PK_UID PRIMARY KEY(U_ID),
CONSTRAINT CHK_BOSS CHECK (ISBOSS>=0 AND ISBOSS<=1)
);
/
CREATE TABLE STATETYPE
(
S_ID NUMBER NOT NULL,
S_NAME VARCHAR(25) UNIQUE NOT NULL,
CONSTRAINT PK_SID PRIMARY KEY(S_ID)
);
/
CREATE TABLE REQUEST
(
R_ID NUMBER NOT NULL,
STATE_ID NUMBER DEFAULT 1,
DATE_REQUEST DATE DEFAULT CURRENT_TIMESTAMP,
DATE_RESOLVE DATE,
AMOUNT NUMBER,
REQUESTER_ID NUMBER NOT NULL,
RESOLVER_ID NUMBER,
PURPOSE VARCHAR2(500),
NOTE VARCHAR2(500),
CONSTRAINT CHK_AMOUNT CHECK (AMOUNT>0),
CONSTRAINT PK_RID PRIMARY KEY(R_ID),
CONSTRAINT FK_STATE FOREIGN KEY(STATE_ID) REFERENCES STATETYPE(S_ID),
CONSTRAINT FK_REQ FOREIGN KEY(REQUESTER_ID) REFERENCES USER_E(U_ID),
CONSTRAINT FK_RES FOREIGN KEY(RESOLVER_ID) REFERENCES USER_E(U_ID)
);
/
INSERT INTO STATETYPE VALUES(1, 'Pending');
INSERT INTO STATETYPE VALUES(2, 'Approved');
INSERT INTO STATETYPE VALUES(3, 'Denied');
SELECT * FROM STATETYPE;
/
CREATE SEQUENCE U_SEQ
START WITH 200
INCREMENT BY 5;
/
CREATE SEQUENCE R_SEQ
START WITH 500
INCREMENT BY 10;
/
CREATE OR REPLACE TRIGGER U_SEQ_TRIGGER
BEFORE INSERT ON USER_E
FOR EACH ROW
BEGIN
  IF :NEW.U_ID IS NULL THEN 
    SELECT U_SEQ.NEXTVAL INTO :NEW.U_ID FROM DUAL;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER R_SEQ_TRIGGER
BEFORE INSERT ON REQUEST
FOR EACH ROW
BEGIN
  IF :NEW.R_ID IS NULL THEN 
    SELECT R_SEQ.NEXTVAL INTO :NEW.R_ID FROM DUAL;
  END IF;
END;
/
/*
REGISTER USER
*/
INSERT INTO USER_E(EMAIL, PASSWRD, FIRSTNAME, LASTNAME,ISBOSS)
VALUES('afaugue','pass','Arthur','Faugue', 1);
/
INSERT INTO USER_E(EMAIL, PASSWRD, FIRSTNAME, LASTNAME, ISBOSS)
VALUES('test','test','Mack','Faugue', 0);
/
/*
LOGIN
*/
SELECT * FROM USER_E WHERE EMAIL='test' AND PASSWRD='test';
/
/*
GET REQUESTER ID FROM USER.GETID() SO METHOD TO CREATE REQUEST NEEDS
USER, AMOUNT, AND OR PURPOSE
*/
INSERT INTO REQUEST(AMOUNT, REQUESTER_ID, PURPOSE)
VALUES(1000,210,'');
/
INSERT INTO REQUEST(AMOUNT, REQUESTER_ID, NOTE)
VALUES(100,210,'');
/
/*
SHOW REQUEST FOR A CERTAIN USER GIVEN REQUESTER ID
*/
SELECT *  FROM REQUEST R 
INNER JOIN USER_E E
ON R.REQUESTER_ID = E.U_ID
where E.U_ID = 210;
/
SELECT S_NAME FROM STATETYPE S
INNER JOIN REQUEST R
ON R.STATE_ID = S.S_ID;
/
/*
SHOW REQUEST FOR A CERTAIN USER GIVEN REQUESTER ID
  AND STATE ID
*/
SELECT *  FROM REQUEST R 
INNER JOIN USER_E E
ON R.REQUESTER_ID = E.U_ID
WHERE E.U_ID = 210 AND R.STATE_ID = 3;
/
commit;
/
/*
LOG IN USING USER NAME AND PASSWORD
*/
SELECT * FROM USER_E WHERE EMAIL='test' AND PASSWRD='test';
/
/*
CURRENT_TIMESTAMP
*/
INSERT INTO REQUEST(AMOUNT, REQUESTER_ID, NOTE, PURPOSE, STATE_ID, RESOLVER_ID, DATE_RESOLVE)
VALUES(350,210,'You did not need it.','I needed it.', 3, 200, CURRENT_TIMESTAMP);