Select e1.name from Employee e2
LEFT JOIN Employee e1 ON
e2.managerId = e1.id
GROUP BY e1.id
HAVING count(e1.id) >= 5;