SELECT GENRE
FROM BOOKS
GROUP BY GENRE; 

SELECT COUNT(TITLE), GENRE
FROM BOOKS
GROUP BY GENRE; 

-- COUNT() IS AN AGGREGATE FUNCTION. GROUP BY IS OFTEN USED WITH AGGREGATE FUNCTIONS. 
-- GROUP BY CAN ONLY USE THE SELECTED COLUMNS

SELECT GENRE
FROM BOOKS
ORDER BY TITLE; 

-- ORDER BY CAN SORT COLUMNS EVEN IF IT'S NOT THE ONE SELECTED

/

SELECT * 
FROM BOOKS 
WHERE GENREID = 1; 

-- WHERE FILTERS ROWS, CAN'T USE AGGREGATE FUNCTIONS WITH THEM 

SELECT COUNT(TITLE), GENRE
FROM BOOKS
GROUP BY GENRE
HAVING COUNT(TITLE) > 100; 

-- HAVING ALLOWS YOU TO FILTER GROUPS OF ROWS AND USE AGGREGATE FUNCTIONS ON THEM 

/
-- 
variables declared up here 
u_id %TYPE;

create or replace procedure get_all_users(sys_cur out sys_refcursor)
is 
begin 
open sys cur for 
select * from users; 
end; 

begin get_all_users(u_cur);
loop 
fetch u_car into u_id, u_fn, u_ln, u_pass, username; 
exit when u_cur%Notfound; 
DBMS_OUTPUT.PUT_LINE(); 
end loop;
close u_cur; 
end; 
-- 
create or replace function get_longest_name
return number
is
max_name number; 
begin 
select max(length(username)) into max_name from users ; 
return max_name;
end; 

