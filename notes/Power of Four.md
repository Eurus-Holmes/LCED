# 原题
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

注意点：

  - 无

例子：

```
Example 1:

Input: 16
Output: true

Example 2:

Input: 5
Output: false
```

# 解题思路

> Follow up: Could you solve it without loops/recursion?

### 思路一
先不考虑Follow up的要求，用循环的方法求解。

```python
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        while num%4 == 0:
            num /= 4
        return num == 1
```

### 思路二
先不考虑进一步的要求，用递归的方法求解。

```python
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        if num == 1:
            return True
        if num%4 == 0:
            return self.isPowerOfFour(num/4)
        else:
            return False
```

### 思路三
题目说了不能循环或递归，上面的解法会TLE。

考虑到输入是“Integer”，是有范围的（<2147483648），所以算出能输入的所有4的幂次，保存到list或dict中，对每次输入判断是否在这些数中即可。

```python
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        nums = [1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824]
        return num in nums
```

### 思路四
4的幂次表现在二进制上，为首位为1，后面有偶数个0。所以先将输入的数转换成2进制，再判断2进制中0和1的个数即可。 

注意：Python里将数转成二进制后的表示为“0bxxxx”，最前面有个0，在计算0的个数时要考虑到。

```python
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return num > 0 and bin(num).count('1') == 1 and bin(num).count('0') % 2 == 1
```

### 思路五
类似思路四，我们可以先判断输入数的二进制形式为1后面若干个0，再判断1是否在奇数位即可。

```python
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return num > 0 and num&(num-1) == 0 and (num & 0x55555555) != 0
```
