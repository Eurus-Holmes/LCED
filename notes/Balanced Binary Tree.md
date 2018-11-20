# 原题
判断一棵二叉树是否是平衡二叉树，只有当每个节点的左右两棵子树的高度差不大于1时，这棵树才是平衡的。

注意点：

  - 无

例子:

```
输入:

    3
   / \
  9  20
    /  \
   15   7
  /
 14
 
输出: False
```

# 解题思路
非平衡的条件是有两个叶子节点的深度相差大于1，
最直接的想法就是把左子树和右子树的高度都算出来，如果相差大于1则说明不是平衡的。
在递归中，从叶子结点开始一层层返回高度，叶子结点是1。
我们返回-1代表非平衡，返回自然数代表有效的子树高度。

### 复杂度
时间 O(N) 空间 O(h) 递归栈空间