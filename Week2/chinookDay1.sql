select * 
from album
where 
length(title) = 95;
/
-- group by and order by 
select albumid, count(trackid)
from track
group by albumid
having albumid <=10
order by albumid DESC;
/
-- like clause
select * from track
where lower(name) like '%';

select * from track;
/

create view album_view 
as 
select * from album where
albumid between 5 AND c20;

select * from album_view;
/
create view artist_view
as 
select * 
from artist
where artistid between 0 AND 15;

select * from artist_view;
/

select al.title as "Album Title", art.name as "Artist Name", tr.name as "Track Name"
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on al.ALBUMID = tr.ALBUMID ;























