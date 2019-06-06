# 原题
判断一个字符的编码（不是一组）是不是有效的UTF-8编码。规则是：

```
对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)；
如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)；
如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节；
如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节； 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节；
```

注意点：

  - The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. 
  This means each integer represents only 1 byte of data.

例子：

```
Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.

Example 2:

data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
```

# 解题思路
注意题目让判断的是一个字符，这样就简单了很多。
方法是使用位运算，首先判断首字符中的起始位置是什么，
来知道后面跟着几个字符或者整个字符是个单独的字符，然后判断后面跟着的字符是不是都是以01开头的，个数是不是和第一个字符指示我们的相等。

时间复杂度是O(N)，空间复杂度是O(1)。N是给出的数据的长度。

