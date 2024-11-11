/*
Write a query to find orders placed in the last 20 days.


Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID      OrderDate       TotalCost                                                                       
1001     1               2024-10-10      1250.00                                                                                 
1002     2               2024-10-12      850.00                                                                                  
  

*/

use fs;
-- write your query below


select OrderId, CustomerId, OrderDate, TotalCost from Orders where DATEDIFF(CURDATE(),OrderDate) <= 33;

-- 20 days till 30th Oct + 13 days till today is 33 days