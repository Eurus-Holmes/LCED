# 原题
给定两个数组，编写函数计算它们的交集。

注意点：

  - 结果中的每个元素的出现次数应与其在两个数组中同时出现的次数一样多。
  - 结果可以采用任意顺序。
  
进一步思考:

  - 如果数组已经排好序，怎样优化你的算法？
  - 如果nums1的长度＜nums2的长度？哪一种算法更好？
  - 如果nums2的元素存储在磁盘上，并且内存大小有限，不足以将其一次性的加载到内存中。此时应当怎样做？

例子：

```
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
```

# 解题思路
### 解法I 排序（Sort）+双指针（Two Pointers）

```python
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1, nums2 = sorted(nums1), sorted(nums2)
        p1 = p2 = 0
        ans = []
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                p1 += 1
            elif nums1[p1] > nums2[p2]:
                p2 += 1
            else:
                ans += nums1[p1],
                p1 += 1
                p2 += 1
        return ans
```

### 解法II Counter计数

该解法不需要将nums2一次性加载到内存中

```python
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        c = collections.Counter(nums1)
        ans = []
        for x in nums2:
            if c[x] > 0:
                ans += x,
                c[x] -= 1
        return ans
```

