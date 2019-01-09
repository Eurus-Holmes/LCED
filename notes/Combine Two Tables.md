# 原题

```
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.


Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
 

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

FirstName, LastName, City, State
```

注意点：

  - 无

例子:

  - 无

# 解题思路
So easy...多表的外连接查询

但值得注意的是这里如果用
```sql
# Write your MySQL query statement below
SELECT FirstName,LastName,City,State
FROM Person,Address
WHERE Person.PersonId = Address.PersonId;
```
会WA，因为Address的PersonId可能为空，就好像有一个Address中还没有住人。。。此时就不会连接到对应的空字段，所以需要用LEFT JOIN ON左外部连接才行。
