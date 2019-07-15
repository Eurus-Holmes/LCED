# 原题
你有n枚硬币，想要组成一个阶梯形状，其中第k行放置k枚硬币。

给定n，计算可以形成的满阶梯的最大行数。

n是非负整数，并且在32位带符号整数范围之内。

注意点：

  - 无

例子：

```
Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
```

# 解题思路
### 解一元二次方程（初等数学）

```
x ^ 2 + x = 2 * n

解得：

x = sqrt(2 * n + 1/4) - 1/2
```
