# Write your MySQL query statement below
SELECT name
FROM SalesPerson 
WHERE name NOT IN (SELECT s.name
FROM SalesPerson s
JOIN Orders o
ON s.sales_id = o.sales_id
WHERE o.com_id = (SELECT com_id FROM Company WHERE name = "RED"))