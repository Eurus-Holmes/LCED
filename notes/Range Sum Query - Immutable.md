# 原题
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

注意点：

  - 无

例子：

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

# 解题思路
保存累积和

可以直接用切片求和的方法做，也能A，但是效率太慢。

可以先把sums求出来，然后再调用的时候直接右边的sums-左边的sums即可得到结果。
