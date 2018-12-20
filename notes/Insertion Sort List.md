# 原题
通过插入排序的方法排序一个链表。

注意点：

  - 无

例子:

```
Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
```

# 解题思路
Insertion Sort就是把一个一个元素往已排好序的list中插入的过程。

初始时，sorted list是空，把一个元素插入sorted list中。然后，在每一次插入过程中，都是找到最合适位置进行插入。

因为是链表的插入操作，需要维护pre，cur和next3个指针。

pre始终指向sorted list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。

当sortedlist为空以及pre.next所指向的元素比cur指向的元素值要大时，需要把cur元素插入到pre.next所指向元素之前。
否则，pre指针后移。最后返回fakehead的next即可。
