# 原题
给定一棵二叉搜索树（BST），寻找BST中两个给定节点的最近公共祖先（LCA）。

根据维基百科对LCA的定义：“节点v与w的最近公共祖先是树T上同时拥有v与w作为后继的最低节点（我们允许将一个节点当做其本身的后继）”

例如，题目描述的样例中，节点2和8的最近公共祖先（LCA）是6。另一个例子，节点2和4的LCA是2，因为根据LCA的定义，一个节点可以是其本身的后继。

```
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```

注意点：

  - 无

例子：

```
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```

# 解题思路
根据二叉搜索树的性质，对于树中从root开始的节点: 

如果p和q的值如果都小于root的值，那么它们的最低公共祖先一定在root的左子树;

如果p和q的值如果都大于root的值，那么它们的最低公共祖先一定在root的右子树;

其他情况则说明最低公共祖先就是root节点。如此循环判断即可。

