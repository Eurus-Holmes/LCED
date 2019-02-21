# 原题
使用队列实现栈的下列操作：

```
push(x) -- 将元素x压入栈.
pop() -- 移除栈顶元素.
top() -- 获得栈顶元素.
empty() -- 返回栈是否为空.
```

注意点：

  - 你可以假设所有的操作都是有效的（例如，不会对空栈执行pop或者top操作）
  - 取决于你使用的语言，queue可能没有被原生支持。你可以使用list或者deque（双端队列）模拟一个队列
  - 只要保证你仅仅使用队列的标准操作即可——亦即只有如下操作是有效的：push to back（加入队尾），pop from front（弹出队首），
  size（取队列大小）以及is empty（判断是否为空）

例子：

```
MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
```

# 解题思路

```
push(x) -- 使用queue的push to back操作.
pop() -- 将queue中除队尾外的所有元素pop from front然后push to back，最后执行一次pop from front
top() -- 将queue中所有元素pop from front然后push to back，使用辅助变量top记录每次弹出的元素，返回top
empty() -- 使用queue的is empty操作.
```

