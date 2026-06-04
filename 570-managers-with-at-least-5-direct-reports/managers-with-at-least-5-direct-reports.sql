SELECT m.name
FROM Employee e
left JOIN Employee m ON e.managerId = m.id
GROUP BY m.id
HAVING COUNT(m.id) >= 5;
