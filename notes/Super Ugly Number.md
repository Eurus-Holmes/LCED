# 原题
编写程序寻找第n个“超级丑陋数”

超级丑陋数是指只包含给定的k个质因子的正数

注意点：

  - 1被认为是超级丑陋数，无论给定怎样的质数列表.

  - 给定的质数列表以升序排列.

  - 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.

例子：

```
Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.
```

# 解题思路
小顶堆（优先队列）

使用Python生成器和heapq.merge，将primes中各个元素的质数倍数合并在一起

顺便可以学习一下heapq, itertools, yield的用法
