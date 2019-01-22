# 原题

```
Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.
```

注意点：

  - 无

例子:

```
Assume that file.txt has the following content:

987-123-4567
123 456 7890
(123) 456-7890

Your script should output the following valid phone numbers:

987-123-4567
(123) 456-7890
```

# 解题思路

这道题让我们验证数字串是否为正确的电话号码的格式，而且规定了正确的格式只有两种(xxx) xxx-xxxx or xxx-xxx-xxxx，
那么我们可以看出来区别就是在前几个字符，而后八个字符都相同, 使用awk命令解.
这道题是难点是如何写匹配的正则表达式, 首先来看‘/.../'表示中间的是要匹配的正则表达式，
然后脱字符^匹配一行的开头，美元符$在正则表达式中匹配行尾，然后再看中间的部分，[0-9]{3}表示匹配三个数字，圆括号括起一组正则表达式. 
它和"|"操作符或在用expr进行子字符串提取(substring extraction)一起使用很有用。那么([0-9]{3}-|[0−9]3 )就可以理解了，
它匹配了xxx-和(xxx) 这两种形式的字符串，然后后面的就好理解了，匹配xxx-xxxx这样的字符串，参见代码如下：

```bash
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt
```
