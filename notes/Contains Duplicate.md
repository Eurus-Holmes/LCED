# 原题
给定一个整数数组，判断数组中是否包含重复元素。如果数组中任意一个数字出现了至少两次，你的函数应该返回true，
如果每一个元素都是唯一的，返回false。

注意点：

  - 无

例子：

输入: nums = [1,2,3]

输出:

```
Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```
# 解题思路
使用set数据结构

### 解法I：

```python
class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def containsDuplicate(self, nums):
        return len(nums) != len(set(nums))
```

### 解法II：

```python
class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def containsDuplicate(self, nums):
        numSet = set()
        for num in nums:
            if num in numSet:
                return True
            numSet.add(num)
        return False
```
