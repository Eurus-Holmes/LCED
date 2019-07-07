# 原题
N叉树的层次遍历。

注意点：

  - 无

例子：

[N-ary Tree Level Order Traversal](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)

# 解题思路
首先得明白，这个N叉树是什么样的数据结构定义的。val是节点的值，children是一个列表，这个列表保存了其所有节点。

层次遍历比较好理解，就是每层的值保存在一个list中，总的再返回一个list即可。

我们知道这个属于先进先出的结构，其实就是用队列就好了。
需要注意是每层都在一个list中，所以在进入队列的时候需要保存一下这个节点属于哪个层。
这样当遍历它的时候，就能直接放入它那层的list的末尾即可。难点在维护这个层数。
