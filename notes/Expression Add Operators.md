# 原题
给定一个只包含数字0-9的字符串以及一个目标值，通过在数字之间添加+, -, *运算符，使得运算结果等于目标值，返回所有可能的组合方案。

注意点：

  - 无

例子：

```
Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:

Input: num = "3456237490", target = 9191
Output: []
```

# 解题思路
注意的问题：

1. 有可能string很长，所以要用长整数。

2. 需要记录last oprand，为的是处理乘号的情况。乘号时的计算公式为: result - lastOP + lastOP * curVaule，如 2 + 3 * 5, 
当计算到要乘5时，result = 2 + 3 = 5, lastOp = 3, curValue = 5, 则最终结果为： 5 - 3 + 3 * 5 = 17 = 2 + 3 * 5。

3. 记录当前结果，用于在num长度为零时， 判断是否与target相等，并加入最终的results中。

4. 需要跳过长于一个零的操作数，如“00”， “000”， etc.

5. 按左操作数从长度为1 到长度为len(num)循环， 并递归。
