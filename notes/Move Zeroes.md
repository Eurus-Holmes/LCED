# 原题
Given an array nums, 
write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

注意点：

  - 无

例子：

Input: [0,1,0,3,12]

Output: [1,3,12,0,0]

# 解题思路
先将所有的非零数移动到前面，再一次性将后面所有数置为0。这样需要用到两个循环。
