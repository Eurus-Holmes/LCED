# 原题
给定一个非空的二维矩阵matrix与一个整数k，在矩阵内部寻找和不大于k的最大矩形和。

注意点：

  - 无

例子：

```
Input: matrix = [[1,0,1],[0,-2,3]], k = 2

Output: 2 

Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
             
```

# 解题思路
题目可以通过降维转化为求解子问题：和不大于k的最大子数组，
解法参考：https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k

首先枚举列的起止范围x, y，子矩阵matrix[][x..y]可以通过部分和数组sums进行表示：

```
sums[i] = Σ(matrix[i][x..y])
```

接下来求解sums数组中和不大于k的最大子数组的和。

如果矩阵的列数远大于行数，则将枚举列变更为枚举行即可。
