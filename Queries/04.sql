/*
write a Query Using Subquery to Get Customers with More Than 2 Orders.


Refer the hint for table structure.

Sample output
-------------
Name            Email                                                                                                           
Alice Johnson   alice.johnson@example.com                                                                               
Bob Smith       bob.smith@example.com 
*/

use fs;
-- write your query below


select Customers.Name, Customers.Email from Customers where ((select count(*) from Orders where Orders.CustomerID=Customers.CustomerId)>2);