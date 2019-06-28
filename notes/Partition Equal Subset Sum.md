# 原题
给定一个只包含正整数的非空数组，判断数组是否可以分成两个和相等的子数组。

注意点：

  - 数组长度与元素大小均不超过100

例子：

```
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
```

# 解题思路
动态规划（Dynamic Programming）

利用数组dp[i]记录和为i的子数组是否存在，初始令dp[0] = 1

```
for num in nums:
    for i in range(sum(nums) - num + 1):
        if dp[i]: dp[i + num] = 1
```
