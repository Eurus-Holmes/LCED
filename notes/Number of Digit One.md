# 原题
给定一个整数n，计算所有小于等于n的非负整数中数字1出现的次数。

注意点：

  - 无

例子：

```
Input: 13

Output: 6 

Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
```

# 解题思路
### 解法I：预处理+从高位向低位枚举1的出现次数

预处理数组ones，ones[x]表示[0, 10 ^ x)范围内包含的1的个数

由高位向低位依次遍历数字n的每一位digit

记digit右边（低位）数字片段为n，size为当前位数，cnt为1的总数

若digit > 1，则cnt += digit * ones[size - 1] + 10 ^ (size - 1)

若digit = 1，则cnt += n + ones[size - 1] + 1

```python
class Solution:
    # @param {integer} n
    # @return {integer}
    def countDigitOne(self, n):
        if n < 0:
            return 0
        ones, x = [0], 0
        while 10 ** x <= 0x7FFFFFFF:
            ones.append(ones[x] * 10 + 10 ** x)
            x += 1
        cnt, size = 0, len(str(n))
        for digit in str(n):
            digit = int(digit)
            size -= 1
            n -= digit * 10 ** size
            if digit > 1:
                cnt += digit * ones[size] + 10 ** size
            elif digit == 1:
                cnt += n + ones[size] + 1
        return cnt
 ```
 
 
### 解法II：计数原理，按位统计该位为1时可能包含的数字总数

由低位向高位依次遍历数字n的每一位curn

记当前位数为c，curn左边（高位）的数字片段为highn，cur右边（低位）的数字片段为lown，lowc = 10 ^ c

若curn = 0，则高位范围为0 ~ highn - 1，低位0 ~ lowc - 1

若curn = 1，则高位范围为0 ~ highn - 1，低位0 ~ lowc - 1；或者 高位为highn， 低位0 ~ lown

若curn ＞ 1，则高位范围为0 ~ highn， 低位为0 ~ lowc - 1

```python
def countDigitOne(self, n):
    ones, m = 0, 1
    while m <= n:
        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1) * (n%m + 1)
        m *= 10
    return ones
```
