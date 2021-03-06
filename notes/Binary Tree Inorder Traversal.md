# 原题
不用递归来实现树的中序遍历。

注意点：

  - 无

例子：

输入: {1,#,2,3}
```
   1
    \
     2
    /
   3
```

输出: [1,3,2]

# 解题思路
用栈中序遍历没有先序遍历那么直观，因为我们不能马上pop出当前元素，
而要先把它的左子树都遍历完才能pop它自己。所有我们先将最左边的所有节点都push进栈，
然后再依次pop并记录值，每pop一个元素后再看它有没有右子树，如果右的话，
我们再将它的右节点和右子树中最左边的节点都push进栈，再依次pop。

### 复杂度
时间 O(b^(h+1)-1) 空间 O(h) 递归栈空间 对于二叉树b=2

[参考链接](https://segmentfault.com/a/1190000003532763)
