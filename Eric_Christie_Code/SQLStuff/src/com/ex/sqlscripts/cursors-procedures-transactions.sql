-- anonomyous blocks
declare
  user_fn user.first_name%type;
  user_ln user.last_name%type;
  begin
    select first_name, last_name into user_fn, user_ln from users where u_id=105;
    
    if SQL%FOUND then
      dbms_output.put_line(user_fn);
    end if;
  end;
/
begin
  update users set first_name='Genesis' where u_id=100;
  commit;
  
/
declare
  user_fn users.first_name%time;
  user_ln user.last_name%type;
  cursor get_names_cursor as select first_name, last_name from users where u_id=105;
begin
  open get_names_cursor;
  fetch get_names_cursor into user_fn, user_ln;
end;
/

-- indexes allow for faster searching through non-key fields (columns that aren't not null unique)