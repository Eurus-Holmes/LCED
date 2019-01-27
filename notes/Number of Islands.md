# 原题

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

注意点：

  - 无

例子:

```
Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
```

# 解题思路
### 标零法
遍历矩阵的每一个点，对每个点都尝试进行一次深度优先搜索，如果搜索到1，就继续向它的四周搜索。
同时我们每找到一个1，就将其标为0，这样就能把整个岛屿变成0。我们只要记录对矩阵遍历时能进入多少次搜索，就代表有多少个岛屿。

#### 复杂度
时间 O(NM) 空间 O(max(N,M)) 递归栈空间

# Reference
  - [[Leetcode] Number of Islands 岛屿个数](https://segmentfault.com/a/1190000003753307)
