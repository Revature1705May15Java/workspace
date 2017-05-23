-- a comment...
SELECT MAX(LENGTH(title))
FROM TenAlbums
WHERE AlbumId != 2;
/
SELECT *
FROM Album
WHERE Title = 'Big Ones';
/
DROP VIEW TenAlbums;
/
CREATE VIEW TenAlbums
AS
SELECT * FROM Album
WHERE AlbumId <= 10;
/
SELECT *
FROM Album
WHERE LENGTH(title) > 50;
/
SELECT COUNT(TrackId), AlbumId
FROM Track
GROUP BY AlbumId
HAVING AlbumId <= 10
ORDER BY AlbumId DESC;
/
SELECT *
FROM Track
WHERE LOWER(name) LIKE '_the%';
/
CREATE VIEW AlbumView
AS
SELECT *
FROM Album
WHERE albumId BETWEEN 5 AND 20;
/
SELECT *
FROM AlbumView;
/
CREATE VIEW ArtistView
AS
SELECT *
FROM Artist
WHERE ArtistId BETWEEN 0 AND 15;
/
SELECT *
From ArtistView;

/
--CREATE VIEW ArtistAlbumJoin as
SELECT al.title as "Album Title", art.name as "Artist Name", tr.name as "Track Name",
  Genre.name as "Genre", pl.name as "Playlist Name", mt.name as "Media Type",
  il.unitPrice as "Price", il.quantity as "Quantity", Invoice.total as "Invoice Total",
  cust.email as "Customer Email", empl.email as "Employee Email"
FROM Album al
INNER JOIN Artist art ON art.artistId = al.artistId
INNER JOIN Track tr ON al.albumId = tr.albumId

INNER JOIN PlaylistTrack pt ON pt.trackId = tr.trackId
INNER JOIN Playlist pl ON pl.playlistId = pt.playlistId

INNER JOIN MediaType mt ON mt.mediaTypeId = tr.mediaTypeId
INNER JOIN Genre ON Genre.genreId = tr.genreId

INNER JOIN InvoiceLine il ON il.trackId = tr.trackId
INNER JOIN Invoice ON Invoice.invoiceId = il.invoiceId

INNER JOIN Customer cust ON cust.customerId = Invoice.customerId
INNER JOIN Employee empl ON empl.employeeId = cust.supportRepId;