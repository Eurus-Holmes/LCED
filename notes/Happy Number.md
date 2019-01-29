# 原题

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

注意点：

  - 无

例子:

```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

# 解题思路
按照“happy number”的定义，直接循环计算各位平方和，观察是否收敛到1，若是则是 happy number。
为了判断循环是否开始重复，要用一个字典（dict）或集合（set）来保存已经出现的数字，dict的效率更高。
