CREATE TABLE StateType (
Stateid NUMBER(10) ,
Sname Varchar2(30) Not Null Unique,
Primary Key (stateid)
);
/
Create TABLE Requests (
Stateid number(10),
opened date default sysdate,
closed date,
amount number(10,2) check(amount>0),
purpose varchar2(75),
requestID number(10),
requesterID number(10) not null,
resolverID number(10),
note varchar2(75),

Primary key(requestid)
)
/
alter table requests add constraint FK_stateID 
foreign key(stateid) references Statetype (stateid) on delete cascade;
/
CREATE TABLE EMPLOYEE (
username varchar2(30) unique not null,
password varchar2(20) Not null,
eid number(10) Primary key,
firstname varchar2(20) not null,
lastname VARCHAR2(20) not null,
isManager number(1),
note VARCHAR2(20)
)

/
alter table requests add constraint FK_requesterID 
foreign key(requesterid) references employee (eid) on delete cascade;
/
alter table requests add constraint FK_resolverID 
foreign key(resolverID) references employee (eid) on delete cascade;
/
Select *
from employee;
/
create or replace TRIGGER a_DATE_TRIGGER
BEFORE INSERT
ON requests
FOR EACH ROW
BEGIN
IF:NEW.OPENED IS NULL THEN
SELECT SYSDATE INTO :NEW.OPENED FROM DUAL;
END IF;
END;
/
CREATE SEQUENCE  "ERSDatabase"."EID_Seq"  
MINVALUE 100
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1
START WITH 100 
CACHE 20 
NOORDER  NOCYCLE ;


/

CREATE SEQUENCE  "ERSDatabase"."RID_Seq"  
MINVALUE 500
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1
START WITH 500 
CACHE 20 
NOORDER  NOCYCLE ;

/

select *
from employee;
/
