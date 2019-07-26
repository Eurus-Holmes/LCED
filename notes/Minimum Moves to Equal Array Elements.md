# 原题
给定一个长度为n的非空整数数组，计算最少需要多少次移动可以使所有元素相等，一次移动是指将n - 1个元素加1。

注意点：

  - 无

例子：

```
Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
```

# 解题思路
一次移动将n - 1个元素加1，等价于将剩下的1个元素减1。

因此累加数组中各元素与最小值之差即可。


