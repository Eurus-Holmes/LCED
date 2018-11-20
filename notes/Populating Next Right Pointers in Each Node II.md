# 原题
为二叉树的节点都添加一个next指针，指向跟它在同一高度的右边的节点，如果右边没有节点，就指向None。
与 [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) 
的区别就是这里的二叉树可以是不完全二叉树。

注意点：

  - 最好只用常量的空间

例子：
```
输入:

         1
       /  \
      2    3
     / \    \
    4   5    7
    
输出:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
```

# 解题思路
这道题跟I的区别就是binary tree不是完全二叉树。
所以root.right.next就不一定等于root.next.left。
所以，目标就是先确定好root的右孩子的第一个有效next连接点，然后再处理左孩子。
