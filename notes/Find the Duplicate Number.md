# 原题
给定一个包含n + 1个整数的数组，其中每一个整数均介于[1, n]之间，证明其中至少有一个重复元素存在。
假设只有一个数字出现重复，找出这个重复的数字。

注意点：

  - 不可以修改数组（假设数组是只读的）
  - 只能使用常数空间
  - 运行时间复杂度应该小于O(n^2)
  - 数组中只存在一个重复数，但是可能重复多次

例子：

```
Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3
```

# 解题思路

### Solution1. 时间复杂度O(n * log n)

#### 二分查找（Binary Search）+ 鸽笼原理（Pigeonhole Principle）


“不允许修改数组” 与 “常数空间复杂度”这两个限制条件意味着：禁止排序，并且不能使用Map等数据结构

小于O(n2)的运行时间复杂度可以联想到使用二分将其中的一个n化简为log n


二分枚举答案范围，使用鸽笼原理进行检验

根据鸽笼原理，给定n + 1个范围[1, n]的整数，其中一定存在数字出现至少两次。

假设枚举的数字为 n / 2：

遍历数组，若数组中不大于n / 2的数字个数超过n / 2，则可以确定[1, n /2]范围内一定有解，

否则可以确定解落在(n / 2, n]范围内。

----
### Solution2. Easiest 4 line Solution, 0(n) time complexity and 0(1) space, Python

```python
for i in range(len(nums)):
	if nums[abs(nums[i])]>0:
		nums[abs(nums[i])]=-nums[abs(nums[i])]
	else:
		return abs(nums[i])
```

So fun~
