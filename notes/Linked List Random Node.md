# 原题
给定一个单链表，返回链表中一个随机节点的值。每一个节点应该被等可能的抽取。

进一步思考：

如果链表很大并且长度未知呢？你可以不使用额外的空间高效地解决此问题吗？

注意点：

  - 无

例子：

```
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
```

# 解题思路
### [蓄水池抽样（Reservoir Sampling）](https://www.cnblogs.com/snowInPluto/p/5996269.html)

蓄水池抽样算法的等概率性可以用数学归纳法证明：

```
I   当链表长度为1时，random.randint(0, 0)恒等于0，因此抽到第1个元素的概率为1

II  假设抽取前n个元素的概率相等，均为1/n

III 当抽取第n+1个元素时：

若random.randint(0, n)等于0，则返回值替换为第n+1个元素，其概率为1/(n+1)；

否则，抽取的依然是前n个元素，其概率为1/n * n/(n+1) = 1/(n+1)
```
