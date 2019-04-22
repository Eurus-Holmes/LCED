# 原题
给定一个有序正整数数组nums以及一个整数n，向数组中添加/补充一些元素，
使其“部分元素和”可以组成范围[1, n]内的所有数字。返回最少需要添加的元素个数。

注意点：

  - 无

例子：

```
Example 1:

Input: nums = [1,3], n = 6
Output: 1 
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:

Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].

Example 3:

Input: nums = [1,2,2], n = 5
Output: 0
```

# 解题思路
### 贪心算法（Greedy Algorithm）

假设数组nums的“部分元素和”可以表示范围[1, total)内的所有数字，

那么向nums中添加元素add可以将表示范围扩充至[1, total + add)，其中add ≤ total，当且仅当add = total时取到范围上界[1, 2 * total)

若nums数组为空，则构造[1, n]的nums为[1, 2, 4, 8, ..., k]，k为小于等于n的2的幂的最大值。

若nums数组非空，则扩展时利用nums中的已有元素。
