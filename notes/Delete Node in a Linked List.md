# 原题
编写一个函数删除单链表中（除末尾节点外）的一个节点，只提供待删除节点。

注意点：

  - 无

例子：

```
Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

# 解题思路
链表基本操作，记待删除节点为node

令node.val = node.next.val，node.next = node.next.next即可

