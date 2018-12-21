# 原题
Sort a linked list in O(n log n) time using constant space complexity.
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
考虑到要求用O(nlogn)的时间复杂度和constant space complexity来sort list，自然而然想到了merge sort方法。

不过这道题要找linkedlist中点，那当然就要用最经典的faster和slower方法，faster速度是slower的两倍，
当faster到链尾时，slower就是中点，slower的next是下一半的开始点。

解决了这些问题，题目就很容易解出了。
