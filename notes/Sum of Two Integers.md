# 原题
对计算两个整数a和b的和，但是不能使用运算符加号和减号。 

注意点：

  - 无

例子：

```
Example 1:

Input: a = 1, b = 2
Output: 3

Example 2:

Input: a = -2, b = 3
Output: 1
```

# 解题思路
```
既然不能使用加法和减法，那么就用位操作。下面以计算5+4的例子说明如何用位操作实现加法： 
1. 用二进制表示两个加数，a=5=0101，b=4=0100； 
2. 用and（&）操作得到所有位上的进位carry=0100; 
3. 用xor（^）操作找到a和b不同的位，赋值给a，a=0001； 
4. 将进位carry左移一位，赋值给b，b=1000； 
5. 循环直到进位carry为0，此时得到a=1001，即最后的sum。
```

上面思路还算正常，然而对于Python就有点麻烦了。因为Python的整数不是固定的32位，所以需要做一些特殊的处理，具体见代码吧。 
代码里的将一个数对0x100000000取模（注意：Python的取模运算结果恒为非负数），是希望该数的二进制表示从第32位开始到更高的位都同是0（最低位是第0位），
以在0-31位上模拟一个32位的int。

### 思路一. 迭代求解

```python
class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        while b != 0:
            carry = a & b
            a = (a ^ b) % 0x100000000
            b = (carry << 1) % 0x100000000
        return a if a <= 0x7FFFFFFF else a | (~0x100000000+1)
```

### 思路二. 递归求解

```python
class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        tmp_a = self.add(a, b)
        return tmp_a if tmp_a <= 0x7FFFFFFF else tmp_a | (~0x100000000+1)

    def add(self, a, b):
        return a if b == 0 else self.add((a ^ b) % 0x100000000, ((a & b) << 1) % 0x100000000)
```
