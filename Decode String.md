# 原题
对字符串进行解码，字符串的编码方式是数字+[字符串] == > 字符串连续重复数字次。求最后解码的字符串是多少。

注意点：

  - 无

例子：

```
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

# 解题思路
### 栈
看到括号匹配的题肯定想到用栈去做。

这个题，遇到’[‘就把之前的字符串进行进栈操作。遇到’]'进行出栈操作。

curstring保存的是出栈操作完成后的字符串。

注意这一步：

```
curstring = prestring + prenum * curstring，
prestring是前面的字符串，
prenum * curstring是这一步骤结束之后的字符串，
所以是前面的字符串+现在的字符串得到目前已有的字符串。
```
