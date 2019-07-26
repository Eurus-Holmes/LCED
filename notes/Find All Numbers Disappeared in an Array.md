# 原题
给定一个整数数组，其中1 ≤ a[i] ≤ n (n = 数组长度)，一些元素出现两次，其他的出现一次。

寻找所有[1, n]中没有出现在数组中的元素。

可以不使用额外空间并在O(n)运行时间求解吗？你可以假设返回列表不算额外空间。

注意点：

  - 无

例子：

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

# 解题思路
### 正负号标记法

遍历数组nums，记当前元素为n，令nums[abs(n) - 1] = -abs(nums[abs(n) - 1])

再次遍历nums，将正数对应的下标+1返回即为答案，因为正数对应的元素没有被上一步骤标记过。