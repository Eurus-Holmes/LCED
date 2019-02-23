# 原题
```
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.
```


注意点：

  - 无

例子：

```
Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5
```

# 解题思路
用num保存上一个数字，用pre_op保存上一个操作符。当遇到新的操作符的时候，需要根据pre_op进行操作。乘除的优先级高于加减。所以有以下规则：

  - 之前的运算符是+，那么需要把之前的数字num进栈，然后等待下一个操作数的到来。 
  - 之前的运算符是-，那么需要把之前的数字求反-num进栈，然后等待下一个操作数的到来。 
  - 之前的运算符是×，那么需要立刻出栈和之前的数字相乘，重新进栈，然后等待下一个操作数的到来。 
  - 之前的运算符是/，那么需要立刻出栈和之前的数字相除，重新进栈，然后等待下一个操作数的到来。

注意比较的都是之前的操作符和操作数，现在遇到的操作符是没有什么用的。

另外，注意Python地板除。。。比如-3//2=2的，和c++不一样。因此真正操作的时候如果遇到负数，使用的用浮点除再取整的方式获得和c++一样的结果。

