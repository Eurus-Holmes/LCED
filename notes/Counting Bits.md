# 原题
给定一个非负整数num。对于每一个满足0 ≤ i ≤ num的数字i，计算其数字的二进制表示中1的个数，并以数组形式返回。

注意点：

  - 很容易想到运行时间 O(n*sizeof(integer)) 的解法。但你可以用线性时间O(n)的一趟算法完成吗?
  - 空间复杂度应当为O(n)
  - 你应当利用已经生成的结果
  - 将数字拆分为诸如 [2-3], [4-7], [8-15] 之类的范围, 并且尝试根据已经生成的范围产生新的范围
  - 数字的奇偶性可以帮助你计算1的个数吗?



例子：

```
Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]
```

# 解题思路

题目给出的提示，可以方便我们思考，不过不管怎样，最好首先将前几个数的二进制写出来观察。比如前10个数：

```
0
1
10
11
100
101
110
111
1000
1001
```

这题的关键在于找到规律，本质是个动态规划问题。对于如何利用已有的数据得到新的数据，方法比较多。

### 思路一
最暴力的思路，数一下每个数的二进制里面1的个数。虽然此做法可以AC，但不符合“Follow up”的要求，效率也低，仅供参考。

```python
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        res = []
        for i in xrange(num + 1):
            res.append(bin(i).count('1'))
        return res
```

### 思路二
通过观察前10个数的二进制，可以发现：[2-3]中1的个数是[0-1]中个数对应加一；[4-7]是[0-3]对应加一；[8-15]是[0-7]对应加一......
本质上，是将最高位的1变成0得到对应的较小的数。

```python
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        dp = [0]
        i = 0
        while True:
            for j in xrange(1<<i, 1<<(i+1)):
                if j > num:
                    return dp
                dp.append(1 + dp[j - (1<<i)])
            i += 1
        return dp
```

说明: 基于上面的思路，可以通过Python的列表extend操作解决问题，不过会浪费一些空间。

如下：

```python
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        dp = [0, 1]
        while len(dp) <= num:
            dp.extend(map(lambda x:x+1, dp))
        return dp[:num+1]
```

### 思路三
上面的思路是将一个数的最高位的1去掉得到较小的数，那么也可以将最低位的1去掉得到较小的数，于是有公式： 

`dp[i] = dp[i&(i-1)] + 1`

```python
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        dp = [0]
        for i in xrange(1, num + 1):
            dp.append(dp[i & (i-1)] + 1)
        return dp
```

### 思路四
另外，可以考虑奇偶性，将当前的数右移一位，若当前数是奇数那么1的个数不变；否则1的个数加一，公式如下： 

`dp[i] = dp[i>>1] + (i&1)`

```python
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        dp = [0]
        for i in xrange(1, num + 1):
            dp.append(dp[i >> 1] + (i & 1))
        return dp
```
