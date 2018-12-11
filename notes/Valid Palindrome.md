# 原题
判断一个字符串是否是回文字符串，只考虑字母和数字，并且忽略大小写。

注意点：

  - 空字符串在这里也定义为回文串

例子:

```
输入: s = "A man, a plan, a canal: Panama"

输出: True

输入: s = "race a car"

输出: False
```

# 解题思路
这道题的几个点，

一就是alphanumeric characters and ignoring cases，字母和数字，忽略大小写。 

二就是考虑空字符串是否为回文，最好在面试时候问下面试官，这里是认为空字符串是回文。

因为忽略大小写，所以就统一为大写。

然后就判断当前检查字符是否符合范围，否则大小指针挪动。

如果发现有大小指针指向的值有不同的，就返回false，否则，继续检查。

最后返回true。