SELECT * FROM tenalbums;
/
create view TenAlbums
as select * from album
where albumid <=10;
/
SELECT * 
FROM album 
where 
title = 'Big Ones';
select length(title) from album;
/
SELECT albumid, count(trackid)
from track
group by albumid
having albumid <=10
order by albumid DESC;
/
--like clause
select * from track
where lower(name) like 'ab_%';
/
select * from track;
/

create view album_view
as 
select * from album where
albumid between 5 and 20;

select * from album_view;
/
create view artist_view
as
select * 
from artist
where artistid between 0 and 15;

select * from artist_view;
/
select al.title as "Album Title", art.name as "Artist Name", tr.name as "Track Name", pt.PLAYLISTID as "PlayList ID",
pl.name as "Playlist Name", gen.name as "Genre", mt.NAME as "Media Type", il.INVOICELINEID, inv.INVOICEID as "Invoice ID"
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on al.ALBUMID = tr.ALBUMID
inner join playlisttrack pt on tr.trackid = pt.TRACKID
inner join playlist pl on pt.playlistid = pl.playlistid
inner join genre gen on tr.genreid = gen.genreid
inner join mediatype mt on tr.mediatypeid = mt.mediatypeid
inner join invoiceline il on tr.trackid = il.trackid
inner join invoice inv on il.invoiceid = inv.invoiceid;