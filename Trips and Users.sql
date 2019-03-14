# Write your MySQL query statement below
SELECT t.Request_at Day, ROUND(SUM(CASE WHEN t.Status LIKE 'cancelled%' THEN 1 ELSE 0 END)/COUNT(*), 2) 'Cancellation Rate'
FROM Trips t JOIN Users u ON t.Client_Id = u.Users_Id AND u.Banned = 'No' 
WHERE t.Request_at BETWEEN '2013-10-01' AND '2013-10-03' GROUP BY t.Request_at;
