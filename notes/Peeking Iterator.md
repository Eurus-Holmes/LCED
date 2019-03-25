# 原题
已有一个迭代器，这个迭代器里面有hasNext()和next()函数，让我们对这个迭代器进行封装，
添加一个能获取下一个元素是什么但不需要弹出的peek()函数。

注意点：

  - 无

例子：

```
Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
```

# 解题思路
peek()通过获取迭代器的next()然后保存当前值就好了。
如果调用自身的next()的时候，需要判断一下当前的值是否存在，如果存在就优先弹出。hasNext()也是同样的道理。

需要注意的两点：

第一，刚开始把保存下一个元素的变量定义为了self.next，这样和函数重名了是不可以的；

第二，注意保存的是int，因此注意不能给self.n初始化任何一个整数值，使用None判断是否保存有元素，if的时候不能简单的if self.n这种操作，
因为当n等于0的时候也会触发。

每个操作的时间复杂度是O(1)，空间复杂度是O(1).

