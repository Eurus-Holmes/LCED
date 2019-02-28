# 原题

Implement the following operations of a queue using stacks.

  - push(x) -- Push element x to the back of queue.
  - pop() -- Removes the element from in front of queue.
  - peek() -- Get the front element.
  - empty() -- Return whether the queue is empty.



注意点：

  - You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, 
  and is empty operations are valid.
  - Depending on your language, stack may not be supported natively. You may simulate a stack by using a list 
  or deque (double-ended queue), as long as you use only standard operations of a stack.
  - You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

例子：

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
```

# 解题思路
由于栈先进后出，和队列先进先出天然矛盾，故考虑采用两个栈，一个只进行入栈push操作，一个只进行出栈pop或peek操作。
当只进行出栈操作的栈空时将另一个栈中的内容push到该栈，如此，就拥有了先进先出的特性。
