# 原题
你和朋友在玩下面的猜数字游戏（Bulls and Cows）：你写下一个4位数的神秘数字然后让朋友来猜，你的朋友每次猜一个数字，你给一个提示，
告诉他有多少个数字处在正确的位置上（称为"bulls" 公牛），以及有多少个数字处在错误的位置上（称为"cows" 奶牛），
你的朋友使用这些提示找出那个神秘数字。

编写函数，根据神秘数字与朋友的猜测，返回一个提示信息，使用A表示公牛，B表示母牛。

你可以假设神秘数字和你朋友的猜测只包含数字，并且长度一定相等。

注意点：

  - 无

例子：

```
Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
```

# 解题思路
bull = secret与guess下标与数值均相同的数字个数

cow = secret与guess中出现数字的公共部分 - bull
