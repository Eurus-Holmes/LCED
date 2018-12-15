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
### Approach 1: Hash Table

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
  
### Approach 2: Two Pointers
这道题连带着II是很经典的，在看CC150时候，纠结这个问题纠结了很久。在读了很多网上资料还有书的讲解以及和别人讨论之后，对这个专题终于明白了。

这一问只需要判断链表是否有环。

当链表没有环时是很好判断的，让一个指针一直往后走，遇见null了自然就没有环。

而如何判断有环，那么就需要引入Faster和Slower的概念了（也是一种双指针方法）。顾名思义，同个时间Faster走的比Slower走的多。一般来说，Slower每次走一步，Faster每次走2步（通常这个概念可以判断链表中间点）。在这里，Faster和Slower同时从起点遍历链表，如果有环那么Slower和Faster肯定会相遇。

为什么他俩肯定能相遇呢？万一一个把一个超了但是没相遇咋办？

直觉和生活经验告诉我，他俩肯定能相遇，比如在操场跑圈，一个快的一个慢的同时开始跑，一直跑，快的肯定能跟慢的相遇。不过有更严谨的说法就更有说服力了。

下面我就引用一下CC150里面外加我的完善来说明怎么证明的这个问题：

假设Faster确实把Slower超了而且他俩还没相遇（类似Faster一下迈了2步，Slower一下迈了一步，Faster超了Slower，但是俩人并没遇上）。那么就假设Faster现在在 i+1 位置而Slower在 i 位置。那么前一时刻，Slower肯定是在 i-1 位置，而Faster肯定在(i+1)-2位置，所以前一时刻，俩人都在 i-1 位置，相遇了。

还有一种情况就是Faster在i+2位置而slower在i位置，那么前一时刻，Faster在i位置，而Slower在 i-1位置。这样问题又回归到上面那种情况了（再往前一时刻，Faster在i-2位置，Slower在i-1-1位置，相遇）。

所以，这就证明Runner和Faster在有环的链表中肯定会相遇。
