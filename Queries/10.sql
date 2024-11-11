/*
write a Query to List Customers Who Never Placed an Order

Refer the hint for table structure.

Sample output
-------------
CustomerID      Name                                                                                                    
8              Henry Taylor                                                                                                    
9              Irene Green 

*/

use fs;
-- write your query below

select Customers.CustomerId, Customers.Name from Customers left join Orders on Orders.CustomerId = Customers.CustomerId
where Orders.OrderID is null;
