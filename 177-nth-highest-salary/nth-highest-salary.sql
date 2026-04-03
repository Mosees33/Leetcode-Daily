CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct e1.salary 
      from employee e1
      where (select count(distinct e2.salary) from employee e2
                where e2.salary > e1.salary) = n-1
  );
END