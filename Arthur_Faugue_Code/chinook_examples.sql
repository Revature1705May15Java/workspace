select * from TEN_ALBUMS;
/
--Order by
select albumid, count(trackid)
from track
group by albumid
having albumid <= 10
order by albumid DESC;
/
--like clause
select * from track
where lower(name)  like '%love%';
/
--create album_view
create view album_view
as
select * from album 
where albumid between 5 and 20;

select * from album_view;
/
--create artist_view
create view artist_view
as
select *
from artist
where artistid between 0 and 15;

select * from artist_view;
/
--inner join & alaises
select a1.title as "Album Title", art.name as "Artist Name"
from album a1
inner join artist art on  art.ARTISTID = a1.ALBUMID
inner join track tr on a1.ALBUMID = tr.ALBUMID;
/
select
  album.artistid,
  artist.artistid
FROM album
inner join artist on album.artistid = artist.artistid;
/
--inner join all tables in chinook
select
  album.artistid,
  artist.artistid,
  album.albumid,
  track.albumid,
  track.mediatypeid,
  mediatype.mediatypeid,
  genre.genreid,
  track.genreid,
  track.trackid,
  invoiceline.trackid,
  playlisttrack.trackid,
  invoiceline.invoiceid,
  invoice.invoiceid,
  playlisttrack.playlistid,
  playlist.playlistid,
  invoice.customerid,
  customer.customerid,
  customer.supportrepid,
  employee.employeeid
from album
inner join artist on album.artistid = artist.artistid
inner join track on album.ALBUMID = track.albumid
inner join mediatype on track.mediatypeid = mediatype.mediatypeid
inner join genre on genre.genreid = track.genreid
inner join invoiceline on track.trackid = invoiceline.trackid
inner join playlisttrack on track.trackid = playlisttrack.trackid
inner join invoice on invoiceline.invoiceid = invoice.invoiceid
inner join playlist on playlisttrack.playlistid = playlist.playlistid
inner join customer on invoice.customerid = customer.customerid
inner join employee on customer.supportrepid = employee.employeeid;
/