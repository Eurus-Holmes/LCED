# 原题
给定一个整数数组，判断其中是否存在两个不同的下标i和j满足：| nums[i] - nums[j] | <= t 并且 | i - j | <= k

注意点：

  - 无

例子：

```
Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
```

# 解题思路
### “滑动窗口” + 字典（桶）
```
如果： | nums[i] - nums[j] | <= t   式a

等价： | nums[i] / t - nums[j] / t | <= 1   式b

推出： | floor(nums[i] / t) - floor(nums[j] / t) | <= 1   式c

等价： floor(nums[j] / t) ∈ {floor(nums[i] / t) - 1, floor(nums[i] / t), floor(nums[i] / t) + 1} 式d
```
其中式b是式c的充分非必要条件，因为逆否命题与原命题等价，所以：

```
如果： floor(nums[j] / t) ∉ {floor(nums[i] / t) - 1, floor(nums[i] / t), floor(nums[i] / t) + 1} 非d

推出： | nums[i] - nums[j] | > t   非a
```

因此只需要维护一个大小为k的窗口（字典）numDict，其中键为nums[i] / t，值为nums[i]。

遍历数组nums时，检查nums[i]与键集{floor(nums[i] / t) - 1, floor(nums[i] / t), floor(nums[i] / t) + 1}对应的值的差值即可。


