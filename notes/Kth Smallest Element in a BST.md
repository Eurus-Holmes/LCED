# 原题
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.


注意点：

  - 无

例子：

```
Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
```

# 解题思路
中序遍历(In-Order Traversal)
