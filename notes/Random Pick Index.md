# 原题
在一个数组中寻找一个数字的索引位置。如果有多个，等概率的随机返回其中的任何一个。

注意点：

  - 无

例子：

```
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
```

# 解题思路
用O(n)的时间复杂度，对整个数组进行遍历，这样如果有数字和target相等就保存下其索引位置。再从这些索引位置中等概率返回任意一个即可。
