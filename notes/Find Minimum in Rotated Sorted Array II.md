# 原题

```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.
```

注意点：

  - The array may contain duplicates.
  
例子:

```
Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0
```

# 解题思路
寻找旋转有序重复数组的最小值是对之前问题的延伸，当数组中存在大量的重复数字时，就会破坏二分查找法的机制，
我们无法取得O(lgn)的时间复杂度，又将会回到简单粗暴的O(n)，比如如下两种情况：

{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} 和 {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}， 
我们发现，当第一个数字和最后一个数字，还有中间那个数字全部相等的时候，二分查找法就崩溃了，
因为二分查找只能在 > 或者 ＜ 时 二分。 当 = 时，会不清楚到底在左边还是右边，

这种情况下，我们将high-- 来缩小范围，略过一个相同数字，这对结果不会产生影响，因为我们只是去掉了一个相同的，
然后对剩余的部分继续用二分查找法，在最坏的情况下，比如数组所有元素都相同，时间复杂度会升到O(n).

