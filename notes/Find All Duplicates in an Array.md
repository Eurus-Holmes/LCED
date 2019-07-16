# 原题
给定一个整数数组，1 <= a[i] <= n (n = 数组长度)，某些元素出现两次，某些出现一次。
寻找数组中所有出现两次的元素。你可以不使用额外空间并且在O(n)运行时间内完成题目吗？



注意点：

  - 无

例子：

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
```

# 解题思路
### 解法I 正负号标记法（一趟遍历）

参考LeetCode Discuss：https://discuss.leetcode.com/topic/64735/java-simple-solution

```
遍历nums，记当前数字为n（取绝对值），将数字n视为下标（因为a[i]∈[1, n]）

当n首次出现时，nums[n - 1]乘以-1

当n再次出现时，则nums[n - 1]一定＜0，将n加入答案
```

```python
class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for n in nums:
            if nums[abs(n) - 1] < 0:
                ans.append(abs(n))
            else:
                nums[abs(n) - 1] *= -1
        return ans
```

### 解法II 位置交换法

```
遍历nums，记当前下标为i

当nums[i] > 0 并且 nums[i] != i + 1时，执行循环：

令n = nums[i]

如果n == nums[n - 1]，则将n加入答案，并将nums[i]置为0

否则，交换nums[i], nums[n - 1]
```

```python
class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in range(len(nums)):
            while nums[i] and nums[i] != i + 1:
                n = nums[i]
                if nums[i] == nums[n - 1]:
                    ans.append(n)
                    nums[i] = 0
                else:
                    nums[i], nums[n - 1] = nums[n - 1], nums[i]
        return ans
```
