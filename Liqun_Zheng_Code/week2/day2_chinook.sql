
-- EXISTS will tell you whether a query returned any results
select * 
from album
where exists(select *
from track
where album.albumid = track.albumid)
/

--IN is used to compare one value to several, and can use literal values
select *
from album 
where album.albumid in (4,5,7);
/
---You can also use query results with the IN clause
select * 
from album
where album.albumid in(select track.albumid
from track
where track.albumid = album.albumid);
/

--The UNION operator is used to combine the result-set of two or more SELECT statements.
--Each SELECT statement within UNION must have the same number of columns
--The columns must also have similar data types
--The columns in each SELECT statement must also be in the same order

--select track.albumid
--from track
--where track.albumid = 2
--union 
--select albumid.albumid
--from album
--where albumid.albumid = 4;


--The INTERSECT query will return the records in the blue shaded area. These are the records that exist in both Dataset1 and Dataset2.
--
--Each SQL statement within the SQL INTERSECT must have the same number of fields in the result sets with similar data types.
--SELECT expression1, expression2, ... expression_n
--FROM tables
--[WHERE conditions]
--INTERSECT
--SELECT expression1, expression2, ... expression_n
--FROM tables
--[WHERE conditions];


