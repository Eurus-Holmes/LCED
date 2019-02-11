# 原题
从一个未经排序的数组中找出第k大的元素。注意是排序之后的第k大，而非第k个不重复的元素。

注意点：

  - 无

例子:

```
Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```

# 解题思路
  - O(n)解法：快速选择（QuickSelect）算法，参考[耶鲁大学关于QuickSelect算法的介绍](http://www.cs.yale.edu/homes/aspnes/pinewiki/QuickSelect.html)

```python
import random
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer}
    def findKthLargest(self, nums, k):
        pivot = random.choice(nums)
        nums1, nums2 = [], []
        for num in nums:
            if num > pivot:
                nums1.append(num)
            elif num < pivot:
                nums2.append(num)
        if k <= len(nums1):
            return self.findKthLargest(nums1, k)
        if k > len(nums) - len(nums2):
            return self.findKthLargest(nums2, k - (len(nums) - len(nums2)))
        return pivot
```

  - O(nlogn)解法：排序
  
```python
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer}
    def findKthLargest(self, nums, k):
        return sorted(nums, reverse=True)[k - 1]
```
