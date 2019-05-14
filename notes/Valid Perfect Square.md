# 原题
Given a positive integer num, write a function which returns True if num is a perfect square else False.

注意点：

  - Do not use any built-in library function such as `sqrt`.

例子：

```
Example 1:

Input: 16
Output: true

Example 2:

Input: 14
Output: false
```

# 解题思路
### 思路1. 完全平方式性质
利用完全平方数的性质：

```
a square number is 1+3+5+7+... Time Complexity O(sqrt(N))
```

这个性质就是说一个完全平方数是从1开始的若干连续奇数的和。

### 思路2. 牛顿法
牛顿法详见：https://en.wikipedia.org/wiki/Newton%27s_method.

```
这个问题其实就是求f(x)=num - x ^ 2的零点。

那么，Xn+1 = Xn - f(Xn)/f'(Xn).

又f'(x) = -2x.

得Xn+1 = Xn +(num - Xn ^ 2)/2Xn = (num + Xn ^ 2) / 2Xn = (num / Xn + Xn) / 2.

即t = (num / t + t) / 2.
```

```python
class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        x = num
        while x * x > num:
            x = (x + num / x) / 2
        return x * x == num
```

### 思路3. 二分查找
注意的是left调整到mid+1,right调整到mid-1,这样交叉着才能保证left<= right的判断条件有效。

```python
class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        l, r = 0, num + 1
        # [l, r)
        while l < r:
            mid = l + (r - l) / 2
            if mid * mid == num:
                return True
            if mid * mid < num:
                l = mid + 1
            else:
                r = mid
        return False
```
