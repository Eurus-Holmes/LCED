# 原题
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and 
the absolute difference between i and j is at most k.

注意点：

  - 无

例子：

```
Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```

# 解题思路
首先，遍历nums这个数组（更准确地说是list）。
当某个值第一次出现时，在字典中记录下这个值（以值为key，以该值出现的位置坐标为value）。
接下来，若发现数组中的某个值已经存在于字典中，再进一步通过 存储在字典中的 上一次该元素出现的位置坐标，即value，来判断距离是否不大于k。
