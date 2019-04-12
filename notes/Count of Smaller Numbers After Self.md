# 原题
给定一个整数数组nums，返回一个新的数组counts。
数组counts的第i个元素counts[i]表示位于nums[i]右侧且小于nums[i]的元素个数。

注意点：

  - 无
  
例子：

```
Input: [5,2,6,1]

Output: [2,1,1,0] 

Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
```

# 解题思路
### 树状数组 （Binary Indexed Tree / Fenwick Tree）：

1. 对原数组nums进行离散化处理（排序+去重），将nums从实数范围映射到 [1, len(set(nums))]，记得到的新数组为iNums

2. 从右向左遍历iNums，对树状数组的iNums[i]位置执行+1操作，然后统计(0, iNums[i])的区间和
