--select * from ten_albums;
--/
--create view ten_albums
SELECT * FROM Album 
GROUP BY ALBUMID;  
/
SELECT count(*) from album; 
--this is a comment
/
-- like clause
select * from track
where name like 'The%';
/

--joins
create view album_view 
select * from album 
where albumid between 5 and 20; 

select * from album_view; 
/ 

create view artist_view
select * from artist
where 
artistid between 0 and 15; 

select * from artist_view; 
/
SELECT al.title AS "Album Title", art.name AS "Artist Name", tr.NAME AS "Track Name", plt.TRACKID as "Track Number", 
  pl.playlistid as "Playlist ID", md.MEDIATYPEID as "Media ID", gen.GENREID as "Genre"
FROM album al 
inner join artist art on art.artistid = al.ARTISTID
inner join track tr on al.albumid = tr.albumid 
inner join playlisttrack plt on plt.trackid = tr.trackid 
INNER JOIN playlist pl ON pl.PLAYLISTID = plt.PLAYLISTID 
INNER JOIN mediatype md ON md.MEDIATYPEID = tr.MEDIATYPEID
INNER JOIN genre gen ON gen.GENREID = tr.GENREID; 
