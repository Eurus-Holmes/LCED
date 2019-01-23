# 原题
Given a text file file.txt, transpose its content.

You may assume that each row has the same number of columns and each field is separated by the ' ' character.

注意点：

  - 无

例子:

```
If file.txt has the following content:

name age
alice 21
ryan 30

Output the following:

name alice ryan
age 21 30
```

# 解题思路

这道题让我们转置一个文件，其实感觉就是把文本内容当做了一个矩阵，
每个单词空格隔开看做是矩阵中的一个元素，然后将转置后的内容打印出来。
使用awk关键字,其中NF表示当前记录中的字段个数，就是有多少列，NR表示已经读出的记录数，就是行号，从1开始。
那么在这里NF是2，因为文本只有两列，这里面这个for循环还跟我们通常所熟悉for循环不太一样，
通常我们以为i只能是1和2，然后循环就结束了，而这里的i实际上遍历的数字为1,2,1,2,1,2，
我们可能看到实际上循环了3遍1和2，而行数正好是3，可能人家就是这个机制吧。
知道了上面这些，那么下面的代码就不难理解了，遍历过程如下：

```
i = 1, s = [name]

i = 2, s = [name; age]

i = 1, s = [name alice; age]

i = 2, s = [name alice; age 21]

i = 1, s = [name alice ryan; age 21]

i = 2, s = [name alice ryan; age 21 30]

然后我们再将s中的各行打印出来即可.
```

```bash
awk '{
    for (i = 1; i <= NF; ++i) {
        if (NR == 1) s[i] = $i;
        else s[i] = s[i] " " $i;
    }
} END {
    for (i = 1; s[i] != ""; ++i) {
        print s[i];
    }
}' file.txt
```
