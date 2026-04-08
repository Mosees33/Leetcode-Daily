CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT e1.salary
      FROM employee e1
      WHERE (SELECT COUNT(DISTINCT e2.salary)
             FROM employee e2
             WHERE e1.salary < e2.salary) = n-1
  );
END