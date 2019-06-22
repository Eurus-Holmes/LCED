# 原题
给定一个非负整数数组与一个整数m，你可以将数组拆分成m个非空连续子数组。编写算法使得这m个子数组各自的和的最大值最小化。

注意点：

  - m满足如下约束：1 ≤ m ≤ length(nums) ≤ 14,000

例子：

```
Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
```

# 解题思路
二分枚举答案（Binary Search）

将数组nums拆分成m个子数组，每个子数组的和不小于sum(nums) / m，不大于sum(nums)

又因为数组nums中只包含非负整数，因此可以通过二分法在上下界内枚举答案。

时间复杂度O(n * log m)，其中n是数组nums的长度，m为数组nums的和


