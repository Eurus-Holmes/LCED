# 原题
把一棵二叉树变为链表，也就是一棵所有节点要么没有子节点，要么只有右节点的二叉树。

注意点：

  - 无

例子:

```
输入:

         1
        / \
       2   5
      / \   \
     3   4   6
     
输出:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
```

# 解题思路
如hint所给出，这道题就是使用先序遍历，遍历到的值作为新的右孩子存起来，左孩子变为空。
注意的是，因为右孩子会更新，所以为了递归右子树，要在更新之前提前保存右孩子。
整个程序需要维护一个全局变量，保存当前所遍历的节点。
