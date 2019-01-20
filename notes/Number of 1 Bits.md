# 原题
Write a function that takes an unsigned integer and return the number of '1' bits
it has (also known as the [Hamming weight](http://en.wikipedia.org/wiki/Hamming_weight)).

注意点：

  - Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
  - In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.

例子：

```
Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
```

# 解题思路
通过与运算符判断最低位/最高位是否是1，然后再右移/左移。重复此步骤直到原数归零。

### 注意
右移运算符是算术右移，如果符号位是1的话最高位将补1，符号位是0的话最高位补0。
在C/C++中可以先将原数转换成无符号整数再处理，而在Java中可以使用无符号右移算术符>>>。当然，左移的解法就没有这个问题了。

### 复杂度
时间 O(1) 空间 O(1)
