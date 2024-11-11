/*
write a query to calculate the time difference in days between two orders 
by the same customer and print the records in sorted order by their ID  
and time difference in days of two orders.



Refer the hint for table structure.

Sample output
-------------
OrderID  OrderID  DaysDifference                                                                                          
1003     1011     1                                                                                                       
1011     1012     1                                                                                                       
1003     1012     2                                                                                                       


*/

use fs;
-- write your query below

select o1.OrderID, o2.OrderID, DATEDIFF(o2.OrderDate,o1.OrderDate) as DaysDifference from Orders o1 inner join Orders o2 on o1.CustomerID=o2.CustomerID and o2.OrderDate>o1.OrderDate
order by o1.CustomerID, DaysDifference;
