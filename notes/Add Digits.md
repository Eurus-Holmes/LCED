# 原题
给定一个非负整数，将该整数的所有数字的和作为新的整数，重复直至得到只有一个数的整数。 
进一步：你能不用迭代或循环，在O(1)时间解决该问题吗？

注意点：

  - 无

例子：

```
Input: 38

Output: 2 

Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
```

# 解题思路

### 思路一
先不考虑“进一步”，根据定义来循环计算，效率低，但是可以AC。

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num > 9:
            s = 0
            while num >= 1:
                s += num%10
                num /= 10
            num = s
        return num
```

### 思路二
根据提示，当输入从1到100变化时，可以发现，输出在“1，2，3，4，5，6，7，8，9，1，2，3，4，5，6，7，8，9，…”这样循环。
于是，就有了下面O(1)的算法。 

```
dr(n) = 0, if n = 0 
dr(n) = 9, if n != 0 and n mod 9 == 0 
dr(n) = n mod 9, if n mod 9 != 0 
或， 
dr(n) = 1 + (n-1) mod 9
```

这个问题又叫做[“digit root”](https://en.wikipedia.org/wiki/Digital_root#Congruence_formula)问题


代码一

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 0
        else:
            return 1 + (num - 1) % 9
```

代码二

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0:
            return 0
        elif num % 9 == 0:
            return 9
        else:
            return num % 9
```
