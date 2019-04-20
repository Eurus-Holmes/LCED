# 原题
给定一个整数数组nums，返回其所有落在[low, upper]范围内（包含边界）的区间和的数目。
区间和S(i, j)的定义为所有下标为i到j之间（i ≤ j)的元素的和，包含边界。

注意点：

  - 朴素的O(n^2)解法很容易想到。你的算法必须优于朴素解法。

例子：

```
Input: nums = [-2,5,-1], lower = -2, upper = 2,

Output: 3 

Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
```

# 解题思路
### 朴素解法O(n^2)：
预处理前n项和数组sums，其中sums[i] = ∑(nums, 0, i)

则S(i, j) = sums[j] - sums[i - 1]

两重循环枚举i, j即可。

----
### O(n * logn)解法: 树状数组（Fenwick Tree）：

1. 预处理前n项和数组sums

2. 将sums数组离散化（排序+去重）得到数组osums

3. 遍历sums，记sumi = sums[i]
   用二分查找得到[sumi - upper, sumi - lower]的离散化下标[left, right]
   用树状数组统计范围[left, right]内的元素个数，并累加至最终结果ans
   若lower <= sumi <= upper，额外地令ans+1
   将sumi的离散化下标记入树状数组

上述算法将题目转化为下面的问题：

对于数组sums中的每一个元素sumi，统计出现在sumi左侧，并且数值在[sumi - upper, sumi - lower]范围内的元素个数。

这就等价于统计区间和[0, i]，[1, i]... [i - 1, i]当中所有落在范围[lower, upper]之内的区间个数。
