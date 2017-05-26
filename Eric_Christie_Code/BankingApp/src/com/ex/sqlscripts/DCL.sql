drop user bankdb cascade;
/
create user bankdb
identified by bankdbpass;
--default tablespace;
/
grant connect to bankdb;
grant resource to bankdb;
