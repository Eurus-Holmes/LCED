# 原题
给定一个整数矩阵，计算其最长递增路径的长度。

从每一个单元格出发，你可以向四个方向移动：左右上下。你不可以沿着对角线移动也不能移出边界。（亦即，环绕是不允许的）。

注意点：

  - 无

例子：

```
Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
```

# 解题思路
### 排序+动态规划（Sort + Dynamic Programming）：

将矩阵matrix按照值从小到大排序，得到列表slist，列表元素(x, y, val)存储原矩阵的(行、列、值)

引入辅助数组dp，dp[x][y]表示以矩阵(x, y)元素为终点的最长递增路径长度

遍历slist，同时更新(x, y)左、右、上、下四个相邻元素的dp值
