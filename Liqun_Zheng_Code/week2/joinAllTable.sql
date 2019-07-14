select artist.artistid, album.ALBUMID,
genre.GENREID, mediatype.mediatypeid, track.trackid,
playlisttrack.playlistid, playlist.name, invoiceline.invoicelineid,
invoice.invoiceid, customer.customerid, employee.employeeid
From album
inner join artist on artist.ARTISTID = album.ARTISTID
inner join track on track.ALBUMID=album.ALBUMID
inner join genre on genre.genreid=track.genreid
inner join mediatype on track.MEDIATYPEID = mediatype.MEDIATYPEID
inner join playlisttrack on playlisttrack.TRACKID = track.TRACKID
inner join playlist on playlist.playlistid = playlisttrack.playlistid
inner join invoiceline on invoiceline.trackid = track.trackid
inner join invoice on invoice.invoiceid = invoiceline.invoiceid
inner join customer on customer.customerid = invoice.customerid
inner join employee on employee.employeeid = customer.supportrepid;