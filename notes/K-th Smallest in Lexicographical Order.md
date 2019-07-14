# 原题
给定整数n和k，计算从1到n的整数中字典序第k小的数。


注意点：

  - 1 ≤ k ≤ n ≤ 10^9

例子：

```
Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
```

# 解题思路
### 解法I 直接构造法

初始令答案ans = 1，当k值＞0时执行循环：

计算ans与ans + 1之间的数字个数gap

若gap <= k：则令ans = ans + 1，k = k - gap

否则令ans = ans * 10，k = k - 1

当n, p, q = 35769, 3, 4时，findGap函数执行过程如下：

```
p        q         gap
3        4         1
30       40        11
300      400       111
3000     4000      1111
30000    40000     6881
```

```python
class Solution(object):
    def findKthNumber(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        ans = 1
        k -= 1
        while k > 0:
            gap = self.findGap(n, ans, ans + 1)
            if gap <= k:
                ans += 1
                k -= gap
            else:
                ans *= 10
                k -= 1
        return ans

    def findGap(self, n, p, q):
        gap = 0
        while p <= n:
            gap += max(0, min(n + 1, q) - p)
            p *= 10
            q *= 10
        return gap
```

### 解法II 将整数1到n划分为3个区间分别求解

区间1：字典序 ≤ n

区间2：首位数 = n的首位数，且字典序 ＞ n

区间3：首位数 > n

```python
class Solution(object):
    def findKthNumber(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if n < 10: return k
        sn = str(n)
        po = int('1' * len(sn))
        fd = int(sn[0])
        lo = (fd - 1) * po
        mi = lo + self.calcMi(n)
        hi = lo + self.calcHi(n)
        if k > hi:
            po /= 10
            k -= hi
            fc = (k - 1) / po + fd + 1
            k += fd * po
        elif k > mi:
            return self.solveMi(9 * po / 10, n / 10 + 1, k - mi - 1)
        else:
            fc = (k - 1) / po + 1
        return int(str(fc) + self.solve(9 * po / 10, k - (fc - 1) * po - 1))

    def calcMi(self, n):
        res = 1
        mask = 10 ** int(math.log(n, 10))
        while n > 9:
            res += 1 + n % mask
            n /= 10
            mask /= 10
        return res

    def calcHi(self, n):
        res = 1 + int('1' * (len(str(n)) - 1))
        mask = 10 ** int(math.log(n, 10))
        return res + n % mask

    def solve(self, n, k):
        if k == 0: return ''
        if n <= 10: return str(k - 1)
        po = int('1' * len(str(n)))
        fc = (k - 1) / po
        rest = self.solve(9 * po / 10, k - fc * po - 1)
        return str(fc) + rest

    def solveMi(self, n, k, r):
        if r <= n - k: return k + r
        return self.solveMi(n / 10, k / 10 + 1, r - n + k)
```
