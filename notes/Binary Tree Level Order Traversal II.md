# 原题
实现树的广度优先遍历的倒序遍历，即从最底层依次向上遍历，每一层上的数据按照从左到右的顺序排列。

注意点：

  - 无

例子:

输入:
```

    3
   / \
  9  20
    /  \
   15   7
输出:

[
  [15,7],
  [9,20],
  [3]
]
```

# 解题思路
这题就是简单的二叉树层次遍历。
想要收集自底向上的遍历结果，
只需要在自顶向下每次层次遍历完成时将此层的遍历结果插入到结果list的最前面就好了。
