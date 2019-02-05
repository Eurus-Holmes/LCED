# 原题
给定一个包含n个正整数的数组和一个正整数s，找出其满足和sum ≥ s的子数组的最小长度。如果不存在这样的子数组，返回0

例如，给定数组 [2,3,1,2,4,3]与s = 7，
子数组[4,3]具有满足题设条件的最小长度。

进一步练习：
如果你已经找到了O(n)的解法，尝试使用时间复杂度为O(n log n)的解法完成此题。

注意点：

  - 无

例子:

```
Input: s = 7, nums = [2,3,1,2,4,3]

Output: 2

Explanation: the subarray [4,3] has the minimal length under the problem constraint.
```

# 解题思路
O(n)解法：滑动窗口法，使用两个下标start和end标识窗口（子数组）的左右边界

O(nlogn)解法：二分枚举答案，每次判断的时间复杂度为O(n)

### O(n)版本I：

```python
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        size = len(nums)
        start, end, sum = 0, 0, 0
        bestAns = size + 1
        while end < size:
            while end < size and sum < s:
                sum += nums[end]
                end += 1
            while start < end and sum >= s:
                bestAns = min(bestAns, end - start)
                sum -= nums[start]
                start += 1
        return [0, bestAns][bestAns <= size]
```

### O(n)版本II：

```python
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        size = len(nums)
        start, end, sum = 0, 0, 0
        bestAns = size + 1
        while True:
            if sum < s:
                if end >= size:
                    break
                sum += nums[end]
                end += 1
            else:
                if start > end:
                    break
                bestAns = min(end - start, bestAns)
                sum -= nums[start]
                start += 1
        return [0, bestAns][bestAns <= size]
```

### O(nlogn)版本：

```python
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        size = len(nums)
        left, right = 0, size
        bestAns = 0
        while left <= right:
            mid = (left + right) / 2
            if self.solve(mid, s, nums):
                bestAns = mid
                right = mid - 1
            else:
                left = mid + 1
        return bestAns

    def solve(self, l, s, nums):
        sums = 0
        for x in range(len(nums)):
            sums += nums[x]
            if x >= l:
                sums -= nums[x - l]
            if sums >= s:
                return True
        return False
 ```
