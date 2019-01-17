# 原题

```
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```

注意点：

  - 无

例子:

```
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
```

# 解题思路
最直接的方法就是用Group by...Having Count(*)...的固定搭配来做.
