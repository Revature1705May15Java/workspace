select * from album
where albumid <= 10;
/
select count(*) from (select * from album
where albumid <= 10);
select * from artist;
select * from playlist join playlisttrack on playlist.playlistid=playlisttrack.playlistid join track on track.trackid=playlisttrack.TRACKID;
/
CREATE FUNCTION myAdd (num1 IN NUMBER := 0, num2 IN NUMBER := 0)
RETURN NUMBER IS
  res NUMBER;
BEGIN
  res := num1+num2;
  RETURN res;
END;
/
CREATE OR REPLACE FUNCTION myFactorial (num IN NUMBER := 1) 
RETURN NUMBER IS
BEGIN
  IF num <= 1 THEN
    RETURN 1;
  ELSE
    RETURN num * myFactorial(num - 1);
  END IF;
END;
/

DECLARE
  local_exception EXCEPTION;
  FUNCTION nested_local_function
  RETURN BOOLEAN IS
    retval BOOLEAN := FALSE;
  BEGIN
    RAISE local_exception;
    RETURN retval;
  END;
BEGIN
  IF nested_local_function THEN
    dbms_output.put_line('No raise exception.');
  END IF;
EXCEPTION
  WHEN others THEN
    dbms_output.put_line('DBMS_UTILITY.FORMAT_CALL_STACK');
    dbms_output.put_line('------------------------------');
    dbms_output.put_line(dbms_utility.format_call_stack);
    dbms_output.put_line('DBMS_UTILITY.FORMAT_ERROR_BACKTRACE');
    dbms_output.put_line('-----------------------------------');
    dbms_output.put_line(dbms_utility.format_error_backtrace);
    dbms_output.put_line('DBMS_UTILITY.FORMAT_ERROR_STACK');
    dbms_output.put_line('-------------------------------');
    dbms_output.put_line(dbms_utility.format_error_stack);
END;
/
VARIABLE num_factorial NUMBER CALL myFactorial(5) INTO :num_factorial;
SELECT :num_factorial FROM dual;
/
create view ten_albums as
select * from album
where albumid <= 10;
/
--select * from ten_albums;
select substr(title, 2, 3) as substring, length(title) as len from album
where title > 'Big Ones';
/
select count(albumid), artistid from album
group by artistid; 
/
select count(trackid), albumid, title, track.name
from track join
group by albumid
order by albumid;
/
select artist.name from artist
where artistid not in (select artistid from album where length(title) > 50);
/
create view short_name_artists as
select * from artist
where length(name) < 20;
drop view short_name_artists;
/
create view album_view as
select * from album where albumid between 0 and 15;
create view artist_view as
select * from artist where artistid between 0 and 15;
select album_view.title, artist_view.name
from album_view full outer join artist_view on album_view.artistid = artist_view.artistid;
select album_view.title as albumTitle, artist_view.name as "Artist Name"
from album_view full outer join artist_view on album_view.artistid = artist_view.artistid
where artist_view.artistid not in (select artist_view.artistid 
from artist_view inner join album_view on artist_view.artistid = album_view.artistid);
/
select ar.name, al.title, tr.name as trackTitle
from album al
inner join artist ar on al.artistid = ar.artistid
full outer join track tr on tr.albumid = al.albumid
order by ar.artistid;
/
select count(*)
from artist ar
inner join album al on al.artistid = ar.artistid
inner join track tr on tr.albumid=al.albumid
inner join playlisttrack pt on pt.trackid=tr.trackid
inner join playlist pl on pt.playlistid=pl.playlistid
inner join genre ge on ge.genreid=tr.genreid
inner join mediatype mt on mt.mediatypeid=tr.mediatypeid
inner join invoiceline il on il.trackid=tr.trackid
inner join invoice inv on inv.invoiceid=il.invoiceid
inner join customer cu on cu.customerid=inv.customerid
inner join employee em on em.employeeid=cu.supportrepid;