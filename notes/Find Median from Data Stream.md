# 原题
中位数是指有序整数列表的中间值。如果列表的长度为偶数，此时没有中间值。则其中位数就是两个中间值的平均值。

设计一种数据结构支持下面两种操作：

  - void addNum(int num) - 从数据流向数据结构追加一个整数。
  - double findMedian() - 返回截至目前所有元素的中位数。

注意点：

  - 无

例子：

```
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
```

# 解题思路
维护大顶堆（MaxHeap） + 小顶堆（MinHeap）

需要满足下面的约束条件：

大顶堆中存储的元素 均不大于 小顶堆中的元素

MaxHeap.size() == MinHeap.size()，或者 MaxHeap.size() == MinHeap.size() + 1

则有：

当MaxHeap.size() == MinHeap.size() + 1时，中位数就是MaxHeap的堆顶元素

当MaxHeap.size() == MinHeap.size()时，中位数就是MaxHeap堆顶元素与MinHeap堆顶元素的均值

使用Python的内置堆算法heapq可以很容易地实现小顶堆，而大顶堆可以通过对元素的值 * -1实现。
