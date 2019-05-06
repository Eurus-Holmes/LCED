# 原题
给定一个非空整数数组，返回其前k个出现次数最多的元素。

注意点：

  - 你可以假设k总是有效的，1 ≤ k ≤ 独立元素的个数。
  - 你的算法时间复杂度必须优于O(n log n)，其中n是数组的长度。


例子：

```
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
```

# 解题思路
### 桶排序（Bucket Sort） 

> 时间复杂度O(n)

1. 遍历数组nums，利用字典cntDict统计各元素出现次数。
2. 遍历cntDict，利用嵌套列表freqList记录出现次数为i（ i∈[1, n] ）的所有元素
3. 逆序遍历freqList，将其中的前k个元素输出。

```python
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        n = len(nums)
        cntDict = collections.defaultdict(int)
        for i in nums:
            cntDict[i] += 1
        freqList = [[] for i in range(n + 1)]
        for p in cntDict:
            freqList[cntDict[p]] += p,
        ans = []
        for p in range(n, 0, -1):
            ans += freqList[p]
        return ans[:k]
```

### 哈希表 + 堆 

> 时间复杂度O(n * log k)，其中k为独立元素的个数。

使用collections.Counter的most_common方法，可以使代码简化。

实际上，most_common的实现应用了heapq（堆）模块。

```python
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        c = collections.Counter(nums)
        return [x[0] for x in c.most_common(k)]
```
