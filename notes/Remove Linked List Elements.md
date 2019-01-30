# 原题
Remove all elements from a linked list of integers that have value val.

注意点：

  - 无

例子:

```
Input:  1->2->6->3->4->5->6, val = 6

Output: 1->2->3->4->5
```

# 解题思路
遍历所有节点，同时保留每个节点的上一个节点，当遇到节点值是val时，删除该节点。为了方便操作，定义了一个伪头节点。

