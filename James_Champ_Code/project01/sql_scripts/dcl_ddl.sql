CREATE TABLE employee
(
  employee_id NUMBER        PRIMARY KEY,
  email       VARCHAR2(80)  UNIQUE NOT NULL,
  password    VARCHAR2(40)  NOT NULL,
  firstname   VARCHAR2(60)  NOT NULL,
  lastname    VARCHAR2(60)  NOT NULL,
  ismanager   NUMBER(1),
  CONSTRAINT cons_employee_ismanager  CHECK (ismanager IN(1, 0))
);
/

CREATE TABLE state_type
(
  state_id  NUMBER        PRIMARY KEY,
  name      VARCHAR2(30)  NOT NULL
);
/

CREATE TABLE request
(
  request_id  NUMBER        PRIMARY KEY,
  state_id    NUMBER        DEFAULT 1 NOT NULL,
  open_date   DATE          DEFAULT sysdate NOT NULL,
  close_date  DATE          DEFAULT NULL,
  amount      NUMBER(7,2)   NOT NULL,
  purpose     VARCHAR2(300) NOT NULL,
  employee_id NUMBER        NOT NULL,
  manager_id  NUMBER        DEFAULT NULL,
  note        VARCHAR2(300) DEFAULT NULL,
  CONSTRAINT fk_state FOREIGN KEY(state_id) REFERENCES state_type(state_id),
  CONSTRAINT fk_employee FOREIGN KEY(employee_id) REFERENCES employee(employee_id),
  CONSTRAINT fk_manager FOREIGN KEY(manager_id) REFERENCES employee(employee_id),
  CONSTRAINT cons_request_amount CHECK(amount > 0)
);
/
CREATE SEQUENCE state_id_seq
  START WITH 1
  INCREMENT BY 1;
/
CREATE SEQUENCE request_id_seq
  START WITH 1
  INCREMENT BY 1; 
/
CREATE SEQUENCE employee_id_seq
  START WITH 1
  INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER state_seq_trig
  BEFORE INSERT ON state_type
  FOR EACH ROW
  BEGIN
    IF :new.state_id IS NULL THEN
      SELECT state_id_seq.nextval INTO :new.state_id FROM dual;
    END IF;
  END;
/
CREATE OR REPLACE TRIGGER request_seq_trig
  BEFORE INSERT ON request
  FOR EACH ROW
  BEGIN
    IF :new.request_id IS NULL THEN
      SELECT request_id_seq.nextval INTO :new.request_id FROM dual;
    END IF;
  END;
/
CREATE OR REPLACE TRIGGER employee
  BEFORE INSERT ON employee
  FOR EACH ROW
  BEGIN
    IF :new.employee_id IS NULL THEN
      SELECT employee_id_seq.nextval INTO :new.employee_id FROM dual;
    END IF;
  END;
/