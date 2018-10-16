# 原题
在 [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
（从一个有序的数组中去除重复的数字，返回处理后的数组长度） 的基础上，可以使每个数字最多重复一次，
也就是说如果某一个数字的个数大于等于2个，结果中应保留2个该数字。

注意点：

  - 只能用常量的额外空间
  - 将要保留的数字移到数组前部，剩余的部分不需要处理

例子：

输入: nums = [1,1,1,2,2,3]

输出: 5 ([1,1,2,2,3,3])

# 解题思路
之前是不允许有重复的。

现在是可以最多允许2个一样的元素。

然后删除duplicate，返回长度。

删除duplicate的方法就是指针的操作。具体方法见代码。
