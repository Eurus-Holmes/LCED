# 原题
Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2, also represented as a string.

# 注意点：

  - The length of both num1 and num2 is < 110.
  - Both num1 and num2 contain only digits 0-9.
  - Both num1 and num2 do not contain any leading zero, except the number 0 itself.
  - You must not use any built-in BigInteger library or convert the inputs to integer directly.

例子：

Input: num1 = "2", num2 = "3"

Output: "6"

Input: num1 = "123", num2 = "456"

Output: "56088"

# 解题思路
先抖个机灵：

```python
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        return str(int(num1) * int(num2))
```

上面的能过，下面正经点。

此题是让我们模拟乘法，所以计算方法也就是模拟了小学数学的列竖式。
从末尾数字开始计算乘积，注意进位，先得到num1中每个数字与num2的乘积，再通过10的多少次方的形式代表其位数。

```python
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == '0' or num2 == '0':
            return '0'
        ans = 0
        for i, n1 in enumerate(num2[::-1]):
            pre = 0
            curr = 0
            for j, n2 in enumerate(num1[::-1]):
                multi = (ord(n1) - ord('0')) * (ord(n2) - ord('0'))
                first, second = multi // 10, multi % 10
                curr += (second + pre) * (10 ** j) 
                pre = first
            curr += pre * (10 ** len(num1))
            ans += curr * (10 ** i)
        return str(ans)
```
同样能过。

但是，其实这个题用python这么做是不合理的，因为Python的int可以无限大，所以没有真正实现大数乘法。

所以此题还是选用C++解决。

借鉴LeetCode上的一份高票代码。 

![Figure 1](https://github.com/Eurus-Holmes/LCED/raw/master/images/Multiply-Strings.png)

观看上图，它描述的是我们计算乘法的过程。
仔细分析可以发现，对于原来在上面字符串中下标为1的“2”和在下面字符串中下标为0的“4”的相乘结果08
出现在了最后的乘法结果字符串的下标1和2处。
这一结果对其他下标的数字同样成立：下标i和下标j相乘的高位结果位于下标i+j处，低位位于下标i+j+1处。
根据这个结果，实现高精度的乘法就变得简单了。

```c++
//高票代码版本
class Solution {
public:
    string multiply(string num1, string num2) {
        int m = num1.size();
        int n = num2.size();
        vector<int> array(m+n);
        string ans = "";
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int index1 = i + j;
                int index2 = i + j + 1;
                int sum = (num1[i]-'0')*(num2[j]-'0')+array[index2];
                array[index1] += sum / 10;
                array[index2] = sum % 10;
            }
        }

        for (auto v:array) {
            if (ans.size() != 0 || v != 0)
                ans  += to_string(v);
        }

        return ans.size() == 0?"0":ans;
    }
};
```
