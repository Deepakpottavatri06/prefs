/*
write a Query to Get Products Ordered More Than 3 Times

Refer the hint for table structure.

Sample output
-------------
Name        TimesOrdered                                                                                                    
Keyboard        4                                                                                                       
Mouse           6                                                                                                               

*/

use fs;
-- write your query below

select Products.Name, COUNT(OrderItems.OrderId) as TimesOrdered from Products join OrderItems on OrderItems.ProductID=Products.ProductID
group by Products.Name
having TimesOrdered>3;
