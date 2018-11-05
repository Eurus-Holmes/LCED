# 原题
实现树的广度优先遍历，每一层上的数据按照从左到右的顺序排列。

注意点：

  - 无

例子：

```
输入:

    3
   / \
  9  20
    /  \
   15   7
   
输出:

[
  [3],
  [9,20],
  [15,7]
]
```

# 解题思路
### BFS

典型的BFS, 使用queue. 两层循环，外层判断queue 是否为空，
内层for循环queue的size，然后逐个弹出node， 把左右儿子再压入。 
注意开始的root == null 的判断。

时间复杂度： O(N)

空间复杂度： O(w) where w is maximum width of Binary Tree.

