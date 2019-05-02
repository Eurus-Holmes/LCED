# 原题
给定给一个正整数n，将其分解成至少两个正整数的和，使这些整数的积最大化。返回可以得到的最大乘积。

注意点：

  - 无

例子：

```
Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
```

# 解题思路

观察n为7到10的情形寻找规律：

```
7  -> 3 * 4     -> 12
8  -> 2 * 3 * 3 -> 18
9  -> 3 * 3 * 3 -> 27
10 -> 3 * 3 * 4 -> 36
```

可以发现得到的拆分结果中，各元素的差值均不超过1。

### 解法I 整数均摊

将整数n均摊为m个相差不超过1的整数，m从2到n进行枚举。

```python
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        return max([reduce(operator.mul, self.splitInt(n, m)) for m in range(2, n + 1)])
    
    def splitInt(self, n, m):
        quotient = n / m
        remainder = n % m
        return [quotient] * (m - remainder) + [quotient + 1] * remainder
```

上面的代码复杂度实际上是O(n ^ 2)，可以将复杂度简化为O(n)。

```python
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        return max([self.mulSplitInt(n, m) for m in range(2, n + 1)])
    
    def mulSplitInt(self, n, m):
        quotient = n / m
        remainder = n % m
        return quotient ** (m - remainder) * (quotient + 1) ** remainder
```

上述解法还可以进一步将时间复杂度优化为O(1)。

观察n从2到13时的情形：

```
2  ->  1 * 1
3  ->  2 * 1
4  ->  2 * 2
5  ->  3 * 2
6  ->  3 * 3
7  ->  3 * 2 * 2
8  ->  3 * 3 * 2
9  ->  3 * 3 * 3
10 ->  3 * 3 * 2 * 2
11 ->  3 * 3 * 3 * 2
12 ->  3 * 3 * 3 * 3
13 ->  3 * 3 * 3 * 2 * 2
```

从上面可以找到如下规律：

```
n / 3 <= 1 时，分为两个数的乘积，尽量均摊
n / 3 > 1 时，分为若干个3和2的乘积
n % 3 == 0 时，分为n个3的乘积
n % 3 == 1 时，分为n-1个3和两个2的乘积
n % 3 == 2 时，分为n个3和一个2的乘积
```

```python
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        div = n / 3
        if div <= 1:
            return (n / 2) * (n / 2 + n % 2)
        mod = n % 3
        if mod == 0:
            return 3 ** div
        elif mod == 1:
            return 3 ** (div - 1) * 4
        elif mod == 2:
            return 3 ** div * 2
```

### 解法II 动态规划

dp[i]表示整数i拆分可以得到的最大乘积，则dp[i]只与dp[i - 2], dp[i - 3]两个状态有关

得到状态转移方程：

```
dp[x] = max(3 * dp[x - 3], 2 * dp[x - 2])
```

当x <= 3时，需要对结果进行特判。

```python
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 3: return n - 1
        dp = [0] * (n + 1)
        dp[2], dp[3] = 2, 3
        for x in range(4, n + 1):
            dp[x] = max(3 * dp[x - 3], 2 * dp[x - 2])
        return dp[n]
```


