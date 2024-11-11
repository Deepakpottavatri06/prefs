/*
write a query to Calculate the time difference in hours between 
two orders by the same customer and print the records in sorted order by 
their ID and time difference in hours of two orders.


Refer the hint for table structure.

Sample output
-------------
OrderID  OrderID  HoursDifference                                                                                         
1003     1011     24                                                                                                      
1011     1012     24                                                                                                      
1003     1012     48                                                                                                      

   

*/

use fs;
-- write your query below

select o1.OrderID, o2.OrderID, DATEDIFF(o2.OrderDate,o1.OrderDate)*24 as HoursDifference from Orders o1 inner join Orders o2 on o1.CustomerID = o2.CustomerID and o2.OrderDate>o1.OrderDate
order by o1.CustomerID, HoursDifference;