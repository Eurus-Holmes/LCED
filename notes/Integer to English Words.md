# 原题
将非负整数转化为其英文单词表示。给定输入确保小于 2 ^ 31 - 1

注意点：

  - 无

例子：

```
Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```

# 解题思路

### 思路1
是否发现了将数字拆分成一组单词的模式？例如，123和123000。

将数字以千为单位分组（3位数）。可以写一个帮助函数，输入一个小于1000的数，然后将其转化为单词。

有许多边际样例。好的测试样例是什么？你的代码可以正确处理诸如0或者1000010的输入吗？（单词中间的0不应该输出）

使用除法和取模运算将数字以千为单位拆分成数组，再分别做单词转化

注意边界条件的处理，不需要考虑添加单词And


### 思路2

#### 递归版本:

```python
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        to19 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
               'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
        tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()
        def words(n):
            if n < 20:
                return to19[n-1:n]
            if n < 100:
                return [tens[n/10-2]] + words(n%10)
            if n < 1000:
                return [to19[n/100-1]] + ['Hundred'] + words(n%100)
            for p, w in enumerate(('Thousand', 'Million', 'Billion'), 1):
                if n < 1000**(p+1):
                    return words(n/1000**p) + [w] + words(n%1000**p)
        return ' '.join(words(num)) or 'Zero'
```
