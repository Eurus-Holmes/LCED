原题

```
Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
```

注意点：

  - 无
  
例子:

```
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
```

# 解题思路
直接在三个表的实例中查找，然后把四个条件限定上，就可以返回正确结果.

[Consecutive Numbers 连续的数字](http://www.cnblogs.com/grandyang/p/5354173.html)
