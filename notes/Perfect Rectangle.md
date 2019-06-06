# 原题
给定N个与坐标轴对齐的矩形（其中N > 0），判断它们是否恰好围成一个矩形区域。

每一个矩形通过左下角和右上角的坐标表示。例如，一个单位正方形用[1,1,2,2]表示。（左下角坐标(1, 1)，右上角坐标(2, 2)）.

注意点：

  - 无

例子：

```
Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.
 

 

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.
 

 

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.
 

 

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.
```

# 解题思路
### 顶点检查法
利用points记录各个顶点被矩形的覆盖情况

记矩形的左下、右下、右上、左上顶点为A、B、C、D，则有：

```
左下顶点A的坐标为(l, b)
右下顶点B的坐标为(r, b)
右上顶点C的坐标为(r, t)
左上顶点D的坐标为(l, t)
```

如下图所示：

```
        G
D |-----|-----| C
  |     |     |  
H |-----I-----| F
  |     |     |  
A |-----|-----| B
        E
```

将左下A、右下B、右上C、左上D分别标号为1、2、4、8（这样标号便于位运算），则有：

```
points[A] |= 1
points[B] |= 2
points[C] |= 4
points[D] |= 8

points[E] = points[A] | points[B] = 3 （左下顶点、右下顶点的并）
points[F] = points[B] | points[C] = 6 （右下顶点、右上顶点的并）
points[G] = points[C] | points[D] = 12 （右上顶点、左上顶点的并）
points[H] = points[A] | points[D] = 9 （左下顶点、左上顶点的并）
points[I] = points[A] | points[B] | points[C] | points[D] = 15（四个顶点的并）
```
