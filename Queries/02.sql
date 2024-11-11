/*
write a Query to Get the Top 3 Customers by Total Spending.

Refer the hint for table structure.

Sample output
-------------
Name            TotalSpent                                                                                                      
Alice Johnson   1625.00                                                                                                 
George Clark    1200.00                                                                                             

*/

use fs;
-- write your query below


select Customers.Name, SUM(Orders.TotalCost) as TotalSpent from Customers join Orders on Orders.CustomerID = Customers.CustomerID
GROUP BY Customers.Name
ORDER BY TotalSpent DESC LIMIT 3;