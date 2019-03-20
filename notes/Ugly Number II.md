# 原题
编写一个程序，找出第 n个丑数。
丑数就是只包含质因数2, 3, 5 的正整数。

注意点：

  - 无

例子：

```
IInput: n = 10

Output: 12

Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
```

# 解题思路

1. 这个可以考虑动态规划的思想，要求第n个丑数，思考一下，第n个丑数是怎么来的？它一定是在第n个丑数之前的n-1个丑数中的一个，乘以2、3、5得来的。
现在的问题就是，如何从前n-1个丑数中选出那个丑数来，然后又如何确定是乘以2，还是3 或者是5？
2. 解决办法，用一个ugly[i]表示第i+1个丑数，维护一系列丑数。
3. 用变量i2记录在ugly[]中出现的第一个丑数，且，这个丑数乘以2 大于ugly[]中最后一个丑数。 
此时，很显然ugly[i2] * 2就是下一个丑数的备选值，同理选出ugly[i3] * 3、ugly[i5] * 5，
然后从这三个值里面选择最小的作为下一个丑数。以此类推，直到选出n个来。