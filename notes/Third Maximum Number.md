# 原题
给定一个整数数组，返回数组中第3大的数，如果不存在，则返回最大的数字。时间复杂度应该是O(n)或者更少。

注意点：

  - 无

例子：

```
Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```

# 解题思路
利用变量a, b, c分别记录数组第1,2,3大的数字

遍历一次数组即可，时间复杂度O(n)
