DROP USER bank_admin CASCADE;

CREATE USER bank_admin
IDENTIFIED BY p4ssw0rd;

GRANT connect to bank_admin;
GRANT resource to bank_admin;