# 原题
我们来玩猜数字游戏。游戏规则如下：

我挑选一个1到n之间的数字。你来猜我选的是哪个数字。

每一次你猜错，我都会告诉你数字高了还是低了。

你可以调用一个预定义的API guess(int num)，返回3种结果 (-1, 1, 或 0)：

```
-1 : 我的数字更低
 1 : 我的数字更高
 0 : 恭喜你！猜对了！
```

注意点：

  - 无

例子：

Input: n = 10, pick = 6

Output: 6

# 解题思路

Binary Search...

关键是理解题意。。。

要注意的是
```
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
```
这里 My number指的是事先定义好的实际的数字而不是我现在猜的数字。。。
