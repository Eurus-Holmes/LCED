# 原题
给定一个只包含小写或者大写字母的字符串，寻找用这些字母可以组成的最长回文串的长度。

注意点：

  - 大小写敏感，例如"Aa"在这里不认为是一个回文
  - 假设给定字符串的长度不超过1000

例子：

```
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
```

# 解题思路
统计每个字母的出现次数：

若字母出现偶数次，则直接累加至最终结果

若字母出现奇数次，则将其值-1之后累加至最终结果

若存在出现奇数次的字母，将最终结果+1 (例如aaa，bbbbb，ccccccc)


