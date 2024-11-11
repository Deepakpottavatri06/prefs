/*
write a Query to List Products with No Orders.

Refer the hint for table structure.

Sample output
-------------
ProductID       Name                                                                                                    
103            Headphones  
*/

use fs;
-- write your query below


select Products.ProductID, Products.Name from Products LEFT JOIN OrderItems on OrderItems.ProductID = Products.ProductID
WHERE OrderItems.ProductID is null;