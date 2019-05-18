# 原题
给定两个递增有序的整数数组nums1和nums2，以及一个整数k。

定义一个数对(u, v)，包含第一个数组中的一个元素以及第二个数组中的一个元素。

寻找和最小的k个这样的数对(u1,v1),(u2,v2) ...(uk,vk)。


注意点：

  - 无

例子：

```
Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
```

# 解题思路
### 解法I 利用堆数据结构（Heap）

记nums1的下标为i，nums2下标为j；数组长度为size1，size2；

首先将“守卫元素”（MaxInt, None, None）加入堆

令i = j = 0

将nums1[0] + nums2[j]与堆顶元素top进行比较：

若堆顶元素较大，则将(nums1[i] + nums2[j], i, j)加入堆，i取值[0, size1)；然后令j = j + 1

将堆顶元素弹出加入结果集

循环直到结束
对于特定的输入，上述算法会退化为将nums1与nums2的笛卡尔积全部加入堆。

```python
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        heap = [(0x7FFFFFFF, None, None)]
        size1, size2 = len(nums1), len(nums2)
        idx2 = 0
        while len(ans) < min(k, size1 * size2):
            if idx2 < size2:
                sum, i, j = heap[0]
                if nums2[idx2] + nums1[0] < sum:
                    for idx1 in range(size1):
                        heapq.heappush(heap, (nums1[idx1] + nums2[idx2], idx1, idx2))
                    idx2 += 1
            sum, i, j = heapq.heappop(heap)
            ans.append((nums1[i], nums2[j]))
        return ans
```

### 解法I的优化：参阅LeetCode Discuss：https://discuss.leetcode.com/category/491/find-k-pairs-with-smallest-sums

首先将（nums1[i] + nums2[0], i, 0）加入堆，i取值范围[0, size1)

弹出堆顶元素sum, i, j，将(nums1[i], nums2[j])加入结果集ans

若j + 1 < size2，则将(nums1[i] + nums2[j + 1], i, j + 1)加入堆

循环直到结束

```python
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        size1, size2 = len(nums1), len(nums2)
        if size1 * size2 == 0: return ans
        heap = []
        for x in range(size1):
            heapq.heappush(heap, (nums1[x] + nums2[0], x, 0))
        while len(ans) < min(k, size1 * size2):
            sum, i, j = heapq.heappop(heap)
            ans.append((nums1[i], nums2[j]))
            if j + 1 < size2:
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
        return ans
```

### 更高效的解法，参阅LeetCode Discuss：https://discuss.leetcode.com/category/491/find-k-pairs-with-smallest-sums

该解法同样使用了堆，记堆顶元素中两个数组的下标分别为i, j

比上面解法优化之处在于：在向堆中添加新元素时，只考虑i, j + 1；（当j == 0时额外考虑i + 1, 0）

```python
def kSmallestPairs(self, nums1, nums2, k):
    queue = []
    def push(i, j):
        if i < len(nums1) and j < len(nums2):
            heapq.heappush(queue, [nums1[i] + nums2[j], i, j])
    push(0, 0)
    pairs = []
    while queue and len(pairs) < k:
        _, i, j = heapq.heappop(queue)
        pairs.append([nums1[i], nums2[j]])
        push(i, j + 1)
        if j == 0:
            push(i + 1, 0)
    return pairs
```
