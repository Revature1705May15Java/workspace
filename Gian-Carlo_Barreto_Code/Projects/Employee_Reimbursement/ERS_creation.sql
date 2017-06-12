-- Create the tables
CREATE TABLE Employee
(
    emp_id NUMBER,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL UNIQUE,
    password VARCHAR2(50) NOT NULL,
    is_manager NUMBER(1) NOT NULL,
    CONSTRAINT pk_empid PRIMARY KEY (emp_id)
);

CREATE TABLE State_Type
(
    state_id NUMBER,
    name VARCHAR2(50) NOT NULL UNIQUE,
    CONSTRAINT pk_stateid PRIMARY KEY (state_id)
);

CREATE TABLE Request
(
    req_id NUMBER,
    emp_id NUMBER NOT NULL,
    state_id NUMBER DEFAULT 1,
    amount NUMBER(12, 2) NOT NULL,
    open_date DATE NOT NULL,
    close_date DATE,
    purpose VARCHAR2(2000),
    manager_id NUMBER,
    manager_note VARCHAR2(2000),
    CONSTRAINT pk_reqid PRIMARY KEY (req_id),
    CONSTRAINT fk_empid FOREIGN KEY (emp_id) REFERENCES Employee(emp_id),
    CONSTRAINT fk_stateid FOREIGN KEY (state_id) REFERENCES State_Type(state_id),
    CONSTRAINT fk_managerid FOREIGN KEY (manager_id) REFERENCES Employee(emp_id),
    CONSTRAINT chk_amount CHECK (amount > 0)
);

-- Create sequence for Employee table
CREATE SEQUENCE emp_seq
    START WITH 1000
    INCREMENT BY 5;
/

-- Create sequence for Request table
CREATE SEQUENCE req_seq
    START WITH 1
    INCREMENT BY 1;
/

-- Create trigger for emp_id in Employee table
CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
  IF :new.emp_id IS NULL THEN
    SELECT emp_seq.nextval INTO :new.emp_id FROM DUAL;
  END IF;
END;
/

-- Create trigger for req_id in Request table
CREATE OR REPLACE TRIGGER req_seq_trigger
BEFORE INSERT ON Request
FOR EACH ROW
BEGIN
  IF :new.req_id IS NULL THEN
    SELECT req_seq.nextval INTO :new.req_id FROM DUAL;
  END IF;
END;
/

-- Create a trigger to input the currect date in the open_date column of the Request table
CREATE OR REPLACE TRIGGER req_opendate_trigger
BEFORE INSERT ON Request
FOR EACH ROW
BEGIN
  IF :new.open_date IS NULL THEN
    SELECT CURRENT_TIMESTAMP INTO :new.open_date FROM DUAL;
  END IF;
END;
/

-- Insert records into the State_Type table
INSERT INTO State_Type VALUES (1, 'PENDING');
INSERT INTO State_Type VALUES (2, 'APPROVED');
INSERT INTO State_Type VALUES (3, 'DENIED');

-- Create a procedure to close a request
CREATE OR REPLACE PROCEDURE close_request(id IN NUMBER, state IN NUMBER, manager IN NUMBER, note IN VARCHAR2)
  IS
  BEGIN
    UPDATE Request SET state_id = state, close_date = CURRENT_TIMESTAMP, manager_id = manager, manager_note = note WHERE req_id = id;
    COMMIT;
  END close_request;
/