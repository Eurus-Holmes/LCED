# 原题
给定一个数字n，从1~n中选取一个数字y让你猜。
在猜的过程中，会告诉你你当前猜的数字x是比y大还是小，猜错的话，需要付$x。给定n,我们最少需要多少的钱来确保我们猜出y呢？

注意点：

  - 无

例子：

```
n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
```

# 解题思路

### 记忆化搜索
这题要求我们在猜测数字y未知的情况下（1~n任意一个数），要我们在最坏情况下我们支付最少的钱。也就是说要考虑所有y的情况。

我们假定选择了一个错误的数x，（1<=x<=n && x!=y ）那么就知道接下来应该从[1,x-1 ] 或者[x+1,n]中进行查找。 假如我们已经解决了[1,x-1] 和 [x+1,n]计算问题，我们将其表示为solve(L,x-1) 和solve(x+1,n)，那么我们应该选择max(solve(L,x-1),solve(x+1,n)) 这样就是求最坏情况下的损失。总的损失就是 f(x) = x + max(solve(L,x-1),solve(x+1,n))

那么将x从1~n进行遍历，取使得 f(x) 达到最小，来确定最坏情况下最小的损失，也就是我们初始应该选择哪个数。

上面的说法其实是一个自顶向下的过程（Top-down），可以用递归来解决。很容易得到如下的代码（这里用了记忆化搜索）：

```python
class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        return self.solve(dp, 1, n)
 
    def solve(self, dp, L, R):
        if L >= R: return 0
        if dp[L][R]: return dp[L][R]
        dp[L][R] = min(i + max(self.solve(dp, L, i - 1), self.solve(dp, i + 1, R)) for i in range(L, R + 1))
        return dp[L][R]
```

### 迭代
在记忆化搜索的解法中，c++ 88ms, java 15ms, 而Python则高达1800ms，差点TLE，确实效率不高。

于是将其改为迭代如下：

```python
class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for L in range(n - 1, 0, -1):
            for R in range(L + 1, n + 1):
                dp[L][R] = min(i + max(dp[L][i - 1], dp[i + 1][R]) for i in range(L, R))
        return dp[1][n]
```
