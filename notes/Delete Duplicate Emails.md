# 原题

```
Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
```

注意点：

  - 无

例子:

```
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
```

# 解题思路
这道题让我们删除重复邮箱，那我们可以首先找出所有不重复的邮箱，然后取个反就是重复的邮箱，都删掉即可，
那么我们如何找出所有不重复的邮箱呢，我们可以按照邮箱群组起来，然后用Min关键字挑出较小的，然后取补集删除即可：

 

解法一：

```sql
DELETE FROM Person WHERE Id NOT IN
(SELECT Id FROM (SELECT MIN(Id) Id FROM Person GROUP BY Email) p);
```

我们也可以使用内交让两个表以邮箱关联起来，然后把相同邮箱且Id大的删除掉，参见代码如下：

 

解法二：

```sql
DELETE p2 FROM Person p1 JOIN Person p2 
ON p2.Email = p1.Email WHERE p2.Id > p1.Id;
```

我们也可以不用Join，而直接用where将两表关联起来也行：

 

解法三：

```sql
DELETE p2 FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND p2.Id > p1.Id;
```
