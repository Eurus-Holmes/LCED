# 原题
判断一个链表中是否存在着一个环，能否在不申请额外空间的前提下完成？

注意点：

  - 无

例子:

```
输入:

1->2->3
  |  |
  5<-4
  
输出: True
```

# 解题思路
### Hash Table

**Intuition**

To detect if a list is cyclic, we can check whether a node had been visited before. A natural way is to use a hash table.

**Algorithm**

We go through each node one by one and record each node's reference (or memory address) in a hash table. 
If the current node is null, we have reached the end of the list and it must not be cyclic. 
If current node’s reference is in the hash table, then return true.

### Complexity analysis

  - Time complexity : $O(n)$. We visit each of the nn elements in the list at most once. 
  Adding a node to the hash table costs only $O(1)$ time.

  - Space complexity: $O(n)$. The space depends on the number of elements added to the hash table, 
  which contains at most $n$ elements. 
