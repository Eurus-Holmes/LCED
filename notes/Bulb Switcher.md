# 原题
有n盏初始处于关闭状态的灯泡。你首先打开所有的灯泡。
然后，熄灭所有序号为2的倍数的灯泡。
第三轮，切换所有序号为3的倍数的灯泡（开着的就关掉，关着的就打开）。
第n轮，你只切换最后一只灯泡。计算n轮之后还有几盏灯泡亮着。

注意点：

  - 无

例子：

```
Input: 3

Output: 1 

Explanation: 
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
```

# 解题思路
数学题，答案等于`int(math.sqrt(n))`

对于第i栈灯泡，当i的因子个数为奇数时，最终会保持点亮状态，例如9的因子为1，3，9

而当i的因子个数为偶数时，最终会保持熄灭状态，例如8的因子为：1，2，4，8

当且仅当i为完全平方数时，其因子个数为奇数

为什么只有完全平方数的因子个数为奇数呢？

因为除了完全平方数，其余数字的因子都是成对出现的，而完全平方数的平方根只会统计一次。

前10盏灯泡的开闭过程如下所示：

```
0 0 0 0 0 0 0 0 0 0    0
1 1 1 1 1 1 1 1 1 1    1
1 0 1 0 1 0 1 0 1 0    2
1 0 0 0 1 1 1 0 0 0    3
1 0 0 1 1 1 1 1 0 0    4
1 0 0 1 0 1 1 1 0 1    5
1 0 0 1 0 0 1 1 0 1    6
1 0 0 1 0 0 0 1 0 1    7
1 0 0 1 0 0 0 0 0 1    8
1 0 0 1 0 0 0 0 1 1    9
1 0 0 1 0 0 0 0 1 0    10
```
