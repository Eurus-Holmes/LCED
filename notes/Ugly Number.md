# 原题
判断一个给定的数是否是“ugly number”。
所谓“ugly number”是指质因数仅包含在 2，3，5 中的正数。

注意点：

  - 无

例子：

```
Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3

Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2

Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
```

# 解题思路
依次将所给的数除以 2，3，5 直至无法除尽，如果这时得到1则说明所给的数的质因子不超出2，3，5三个数，否则说明有其他质因数。
