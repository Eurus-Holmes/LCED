# 原题

```
Write a bash script to calculate the frequency of each word in a text file words.txt.

For simplicity sake, you may assume:
```
  - words.txt contains only lowercase characters and space ' ' characters.
  - Each word must consist of lowercase characters only.
  - Words are separated by one or more whitespace characters.


注意点：

  - Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.
  - Could you write it in one-line using Unix pipes?

例子：

```
Assume that words.txt has the following content:

the day is sunny the the
the sunny is is
Your script should output the following, sorted by descending frequency:

the 4
is 3
sunny 2
day 1
```

# 解题思路
```
首先用的关键字是grep命令，该命令一种强大的文本搜索工具，它能使用正则表达式搜索文本，并把匹配的行打印出来，详解请参见这个帖子。后面紧跟的-oE '[a-z]+'参数表示原文本内容变成一个单词一行的存储方式，于是此时文本的内容就变成了：

the
day
is
sunny
the
the
the
sunny
is

下面的sort命令就是用来排序的，参见这个帖子。排完序的结果为：

day
is
is
is
sunny
sunny
the
the
the
the

后面的uniq命令是表示去除重复行命令(参见这个帖子)，后面的参数-c表示在每行前加上表示相应行目出现次数的前缀编号，得到结果如下：

   1 day
   3 is
   2 sunny
   4 the

然后我们再sort一下，后面的参数-nr表示按数值进行降序排列，得到结果：

   4 the
   3 is
   2 sunny
   1 day 

而最后的awk命令就是将结果输出，两列颠倒位置即可.
```
