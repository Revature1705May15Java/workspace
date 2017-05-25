select al.title as "Album Title", art.name as "Artist Name", tr.name as "Track Name", gen.name as "Genre Name", med.name as "MediaType Name", 
plt.playlistid as "Playlist ID", pl.name as "Playlist Name", invl.INVOICELINEID as "Invoiceline id", inv.INVOICEID as "Invoice ID", cus.CUSTOMERID as "Customer ID", emp.EMPLOYEEID
from album al
inner join artist art on art.ARTISTID = al.ARTISTID
inner join track tr on al.ALBUMID = tr.ALBUMID
inner join genre gen on tr.GENREID = gen.GENREID
inner join mediatype med on tr.MEDIATYPEID = med.MEDIATYPEID
inner join playlisttrack plt on tr.TRACKID = plt.TRACKID
inner join playlist pl on plt.PLAYLISTID = pl.PLAYLISTID
inner join invoiceline invl on tr.TRACKID = invl.TRACKID
inner join invoice inv on invl.INVOICEID = inv.INVOICEID
inner join customer cus on inv.CUSTOMERID = cus.CUSTOMERID
inner join employee emp on cus.SUPPORTREPID = emp.EMPLOYEEID;