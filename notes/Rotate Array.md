# 原题
将一个数组中的数字右旋k位，即所有的数字向后移k位，末尾的数字移到开头。

注意点：

  - 使用尽可能多的方法来解决
  - 提供一种只需要O(1)空间的解法

例子:

```
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

# 解题思路
通过三次反转，我们可以很巧妙的实现旋转数组。首先我们将整个数组反转，然后将前k个数字反转，然后再将后面剩下的数字反转，就得到目标数组了。

### 注意
  - 反转数组最简单的方法是交换元素，而交换元素有至少三种方法（临时变量，相加相减，异或）
  - k可能大于数组长度，旋转不止一次，所以我们要先对k取余
  
### 复杂度
时间 O(N) 空间 O(1)
