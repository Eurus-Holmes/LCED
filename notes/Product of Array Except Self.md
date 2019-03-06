# 原题
给定长度为n的整数数组nums，其中n > 1，返回输出数组output，满足output[i]等于除nums[i]之外其余各数的乘积。

不使用除法，在O(n)时间复杂度内完成此题目。

进一步思考：

你可以在常数空间复杂度内完成题目吗？（注意：输出数组不算在空间复杂度分析中）


注意点：

  - 无

例子：

```
Input:  [1,2,3,4]

Output: [24,12,8,6]
```

# 解题思路
为方便打开思路，先不考虑“Follow up”的要求。不能用除法，还要求O(n)的时间复杂度，那么乘法不能做的太过。
考虑先正反两次遍历，一次遍历求每个数左侧的所有数的积，一次遍历求每个数右侧的所有数的积，最后两部分积相乘即得所求。 
下面的代码使用了额外的两个数组，空间复杂度O(n)。

```python
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res, leftMul, rightMul = [0]*len(nums), [0]*len(nums), [0]*len(nums)
        leftMul[0] = rightMul[len(nums)-1] = 1
        for i in xrange(1, len(nums)):
            leftMul[i] = leftMul[i-1] * nums[i-1]
        for i in xrange(len(nums)-2, -1, -1):
            rightMul[i] = rightMul[i+1] * nums[i+1]
        for i in xrange(len(nums)):
            res[i] = leftMul[i] * rightMul[i]
        return res
```

在上面的基础上，实际上用数组存储左右的积并不必要，用临时变量即可，于是有下面的O(1)空间复杂度的解法。

```python
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [0]*len(nums)
        tmp = 1
        for i in xrange(len(nums)):
            res[i] = tmp
            tmp *= nums[i]
        tmp = 1
        for i in xrange(len(nums)-1, -1, -1):
            res[i] *= tmp
            tmp *= nums[i]
        return res
```
