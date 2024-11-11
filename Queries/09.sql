/*
write a Query to Get Monthly Sales Summary

Refer the hint for table structure.

Sample output
-------------
Month      MonthlySales                                                                                                    
2024-10    6475.00

*/

use fs;
-- write your query below


select DATE_FORMAT(Orders.OrderDate,'%Y-%m') as Month, sum(Orders.TotalCost) as MonthlySales from Orders group by Month;