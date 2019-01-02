# 原题

```
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2.
```

注意点：

  - Your returned answers (both index1 and index2) are not zero-based.
  - You may assume that each input would have exactly one solution and you may not use the same element twice.

例子:

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

# 解题思路
两个指针，一个指向开头，一个指向末尾，然后向中间遍历，如果指向的两个数相加正好等于target的话，直接返回两个指针的位置即可，
若小于target，左指针右移一位，
若大于target，右指针左移一位，
以此类推直至两个指针相遇停止，时间复杂度是O(n).
