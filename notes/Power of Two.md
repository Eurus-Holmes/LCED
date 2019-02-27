# 原题
给定一个整数，写一个函数判断它是否是2的若干次幂。


注意点：

  - 无

例子：

```
Example 1:

Input: 1
Output: true 
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16

Example 3:

Input: 218
Output: false
```

# 解题思路
### 思路一
比较直观暴力的想法是，如果每次将这个数除以2没有余数，直到得到数字1，那么这个数就是2的若干次幂。

```python
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 1:
            return False
        while n%2 == 0:
            n /= 2
        return True if n==1 else False
```

说明:

当然，除以2是比较特殊的除法，所以也可以通过移位实现上面的除法。

### 思路二
注意到2的幂次 x 表示成二进制一定是一个1后面若干个0，那么只要计算输入数的二进制表示是否只有一个1即可。

```python
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and bin(n).count('1') == 1
```

### 思路三
类似思路二，2的幂次 x 表示成二进制一定是一个1后面若干个0，那么 x-1 一定是一个0后面若干个1，所以 x & (x-1) = 0 ，非2的幂无法得到0。

```python
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and not (n & n-1)
```

