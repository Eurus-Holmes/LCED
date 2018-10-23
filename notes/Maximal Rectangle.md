# 原题
一个矩阵仅包含1和0，找出其中面积最大的只含有1的矩形，并返回它的面积。

注意点：

  - 矩阵中的元素类型是字符串

例子：

输入:

```
matrix = 
[['1', '1', '0', '1', '0', '1'],
 ['0', '1', '0', '0', '1', '1'],
 ['1', '1', '1', '1', '0', '1'],
 ['1', '1', '1', '1', '0', '1']]
 ```
 
输出: 8

# 解题思路
这道题是要在所有里面全为‘1’的长方形里找出最大面积那个。
往往这种找最大的题目可以考虑用DP，算出所有全‘1'的长方形的面积，
然后过程中不断更新最大面积。但是这道题难点是对于一个点来说DP表示什么，以及跟周边点DP是什么关系。

我们可以这样考虑，对于一个里面全部为’1‘的长方形来说，算其面积，最重要的几个特征是什么？有三个变量必须知道：

```
1. 高度h
2. 左边界的x值x1
3. 右边界的x值x2
```

这样面积即为h * (x2 - x1)
所以对于矩阵中任意一点，我们可以根据以上三个变量维护三个数组，
分别为height[][], right[][], left[][]，来表示以这个点为底边的任意一点，
以这个点为最底向上连续’1‘的长度为轴向左向右扫，能够组成的面积最大的内部全部为’1‘的长方形。
height[i][j]表示以(i, j)为底的往上最大连续’1‘的高度。
left[i][j]， right[i][j]表示以(i, j)点及其height[i][j]高度组成的中轴向左扩散的左边界的横坐标与向右扩散的右边界的横坐标 + 1, 
扩散的要求是必须全部为’1‘。我们可以得出以下推导公式：

```
height[i][j] = matrix[i][j] == '1' ? height[i - 1][j]++ : 0;
left[i][j] = Math.max(left[i - 1][j], currLeft)，currLeft表示对ith行而言，从（i，j)向左连续为'1'直至(i, currLeft)那个点;
right[i][j] = Math.min(right[i - 1][j], currRight)， currRight表示ith行而言，从（i，j)向右连续为'1'直至(i, currRight - 1)那个点;;
```

为便于理解，见下例：

```
matrix:
0 0 0 1 0 0 0 
0 0 1 1 1 0 0 
0 1 1 1 1 1 0

各点height, left及right值如下：

row 0:
h: 0 0 0 1 0 0 0
l: 0 0 0 3 0 0 0
r: 7 7 7 4 7 7 7

row 1:
h: 0 0 1 2 1 0 0
l: 0 0 2 3 2 0 0
r: 7 7 5 4 5 7 7 

row 2:
h: 0 1 2 3 3 1 0
l: 0 1 2 3 2 1 0
r: 7 6 5 4 5 6 7
```

注意代码实现过程中当本身值为'0'时，我们可以设置成left[i][j] = 0, right[i][j] = n, 
并非实际意义，只是为了下一排计算使用。虽然不是实际意义，也不影响后面面积的计算，
因为height[i][j] == 0, 面积必然为0，左右边界值不影响面积计算。

当然代码实现过程中，由于每个点只是与上一行有关，可以用一维数组代替二维数组。

### 复杂度
time: O(mn), space: O(n)
