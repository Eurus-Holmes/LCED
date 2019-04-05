# 原题
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by 
its upper left corner (row1, col1) and lower right corner (row2, col2).

注意点：

  - 无

例子：

```
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
```

# 解题思路
### 预先求和
这个题肯定是用先把所有的和求出来，然后查找的时候直接计算就行了。我们使用的这个求和矩阵保存的是每个位置到整个矩阵的左上角元素这个矩形的所有元素和。
为了方便起见，利用了和DP类似的添加边界的方法，也就是在最左边和最上边添加了全是0的列和行，
这样能保证在求和的时候，每个位置的和是左边的和+上边的和+自身-左上元素的和。

即，我们已知sum(OD), sum(OB), sum(OC), sum(OA)

那么，矩形ABDC的面积：

Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)

计算原始求和矩阵时间复杂度是O(MN)，求面积时间复杂度是O(1)，空间复杂度是O(MN).

[Reference](https://blog.csdn.net/fuxuemingzhu/article/details/83537572)
