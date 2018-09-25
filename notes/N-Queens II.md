# 原题
在[N-Queens](https://leetcode.com/problems/n-queens/description/)的基础上计算出共有多少种不同的解法。

注意点：

  - 只需要计数

例子：

输入: n = 8

输出: 92

# 解题思路
和[N-Queens](https://leetcode.com/problems/n-queens/description/)一样的解决方法，
但是需要注意的是这个是计数，计数的话要用数组，因为数组就会更新里面的值。
如果行数等于总行数，就可以在解决方案的计数上加1了，
如果合法的话才会递归下一行。
