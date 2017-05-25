-- DCL
drop user bank cascade;

create user bank
identified by p4ssw0rd;

grant connect to bank;
grant resource to bank;
grant create session to bank;
grant create table to bank;
grant create view to bank;

conn bank/p4ssw0rd;

-- DDL
create table banker (
  userid number primary key,
  fname varchar(100) not null,
  lname varchar(100) not null,
  password varchar(100) not null,
  email varchar(100) not null unique
);

create table accounttype (
  typeid number primary key,
  name varchar(50)
);

create table bankaccount (
  accountid number primary key,
  balance number(12,2) default 0.0,
  typeid number not null,
  opened date default sysdate,
  closed date,
  constraint fk_accounttype foreign key (typeid) references accounttype(typeid)
);

create table bankeraccount (
  userid number,
  accountid number,
  constraint pk_bankeraccount primary key (userid, accountid),
  constraint fk_user foreign key (userid) references banker(userid),
  constraint fk_account foreign key (accountid) references account(accountid)
);
/

-- banker auto-increment
create sequence banker_seq
  start with 1
  increment by 1;
/
create or replace trigger banker_seq_trg
  before insert on banker
  for each row
  begin
    if inserting and :new.userid is null then
      select banker_seq.nextval into :new.userid from dual;
    end if;
  end;
/

-- bankaccount auto-increment
create sequence account_seq
  start with 1
  increment by 1;
/
create or replace trigger account_seq_trg
  before insert on account
  for each row
  begin
    if inserting and :new.accountid is null then
      select account_seq.nextval into :new.accountid from dual;
    end if;
  end;
/

select * from banker;

commit;
exit;