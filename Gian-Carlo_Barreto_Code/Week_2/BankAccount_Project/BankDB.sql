INSERT INTO Account (balance, type_id) VALUES (100.00, 1);

select * from Account;
/
select * from bank_user;
/
select * from USER_ACCOUNT;

SELECT * 
FROM Account ac 
INNER JOIN User_Account u ON ac.account_id = u.account_id AND u.user_id = 1000;
