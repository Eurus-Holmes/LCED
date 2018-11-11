# 原题
给定一个升序的序列，将它转化为高度平衡的二叉搜索树。

注意点：

  - 同一个序列转化成的二叉搜索树可能有多种

例子:

```
输入: nums = [1,2,3]

输出:

  2
 / \
1   3
```

# 解题思路
先复习下什么是二叉搜索树（引自Wikipedia）：

二叉查找树（Binary Search Tree），也称有序二叉树（ordered binary tree）,排序二叉树（sorted binary tree），
是指一棵空树或者具有下列性质的二叉树：

  - 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
  - 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
  - 任意节点的左、右子树也分别为二叉查找树。

再复习下什么是平衡二叉树（引自GeekforGeek）：

An empty tree is height-balanced. A non-empty binary tree T is balanced if:
   1) Left subtree of T is balanced
   2) Right subtree of T is balanced
   3) The difference between heights of left subtree and right subtree is not more than 1.  

解决方法是选中点构造根节点，然后递归的构造左子树和右子树。
