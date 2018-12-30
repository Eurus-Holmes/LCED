# 原题

```
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.
```

注意点：

  - You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
  - Try to solve it in linear time/space.

# 例子:

```
Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
             
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
```

# 解题思路
## 桶排序
### 复杂度
  - O(N) 时间 
  - O(N) 空间

假设有N个元素A到B。

那么最大差值一定大于floor[(B - A) / (N - 1)]，floor就是向下取整

令bucket（桶）的大小len = floor[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶

对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值

由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择。

对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值中的最大值。
