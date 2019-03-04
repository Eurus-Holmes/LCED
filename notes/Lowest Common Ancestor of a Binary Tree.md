# 原题
给定一棵二叉树，寻找其中两个给定节点的最近公共祖先（LCA）。

根据维基百科对LCA的定义：“节点v与w的最近公共祖先是树T上同时拥有v与w作为后继的最低节点（我们允许将一个节点当做其本身的后继）”

例如，题目描述的样例中，节点5和1的最近公共祖先（LCA）是3。另一个例子，节点5和4的LCA是5，因为根据LCA的定义，一个节点可以是其本身的后继。

```
       _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
```

注意点：

  - 无

例子：

```
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
```

# 解题思路
### 递归
最重要的还是明白递归函数的作用是什么。这个题里面lowestCommonAncestor(root, p, q)函数的作用是判断p和q在root树中最低的公共祖先是什么，
返回值是公共祖先。

这个题的模式叫做devide and conquer. 如果当前节点等于其中的p和q某一个节点，那么找到了节点，返回该节点，否则在左右子树分别寻找。

左右子树两个返回的是什么呢？按照该递归函数的定义，即找到了左子树和右子树里p和q的公共祖先，注意祖先可以是节点自己。
然后根据左右侧找到的节点做进一步的判断。

如果左右侧查找的结果都不为空，说明分别找到了p和q，那么LCA就是当前节点。否则就在不为空的那个结果就是所求。

