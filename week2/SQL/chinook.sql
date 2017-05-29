SELECT * FROM Album WHERE ALBUMID <= 10;  /* comment */
/
--CREATE VIEW ten_albums AS SELECT * FROM Album WHERE albumid <= 10;
--SELECT * FROM Album WHERE TITLE = 'Big Ones';

--SELECT count(trackid), albumid FROM track GROUP BY albumid; --group by example

SELECT count(trackid), albumid FROM track 
GROUP BY albumid HAVING Albumid <= 10 
ORDER BY albumid DESC;

select * from track
where name like '_a_b%'; -- % means any amount, _ any 1 character
/
select * from track
where albumid between 5 and 5;
/
CREATE VIEW album_view 
as
select * from ALBUM where ALBUMID between 5 and 20;
/
CREATE VIEW artist_view 
as
select * from ARTIST where ARTISTID between 0 and 15;
/
select al.title as "Album Title", art.name as "Artist Name", tr.name as "Track Name", gen.name as "Genre Name", -- as "Album Title" just changed the name of the column for this query.
plt.TRACKID as "Track ID", pl.PLAYLISTID as "Playlist ID", mt.name as "Mediatype Name", c.email as "Rep email", e.employeeid as "Rep ID", inv.CUSTOMERID as "Customer ID", invl.INVOICEID as "Invoice CD"
from album al
inner join artist art -- specifying art here allows you to use this alias elsewhere, i.e. art.name instead of artist_view.name
on art.ARTISTID = al.ARTISTID
inner join track tr on al.ALBUMID = tr.ALBUMID
inner join genre gen on al.ALBUMID = gen.GENREID
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on pl.playlistid = plt.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join customer c on c.email = c.email
inner join employee e on e.employeeid = c.supportrepid
inner join invoice inv on inv.CUSTOMERID = c.customerid
inner join invoiceline invl on invl.invoiceid = inv.invoiceid;
/
