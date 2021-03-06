# 原题
给定一组非负整数，将这些整数拼接成最大的数字。由于返回的数字可能非常大，直接返回字符串。

注意点：

  - 无

例子:

```
Example 1:

Input: [10,2]
Output: "210"

Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
```

# 解题思路
## 拼接比较法

要拼成最大数，我们只要让较大的数排在前面，较小的数排在后面就行。然而如何对原数组排序呢？当比较一位数时，直接比较大小就行了，但对于多位数呢？

从第一位向后比较，如果有一位更大，则该数更大，如9大于15，24大于23。

如果某个数的前半部分和另一个数完全相同，则看该数剩下的那部分和另一个数的大小关系，如2332和23比较时，2332是大于23的，因为32大于23。
不过如果细分各种情况，会弄得非常复杂，这里有个技巧，就是我们把两个数拼在一起，然后再把这两个数换个顺序再拼在一起，这时候就可以直接比较了。
比如2332和23，变成233223和232332两个数，这时候那个数更大，就说明这个数前半部分的那个数是更大的，这里是2332。

### 注意
如果排序后第一个数是0，则直接返回0，因为后面的数只有可能是0了。

### 复杂度
时间 O(NlogN) 空间 O(N)
