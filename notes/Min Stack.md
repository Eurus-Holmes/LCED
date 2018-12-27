# 原题
实现一个栈，这个栈除了普通的压栈、弹出、获取栈顶元素外，还要能够在获得栈中的最小元素，且这些操作的时间复杂度为O(1)。

注意点：

  - 这里的弹出操作只需要去除栈顶元素，没有返回值

例子:

```
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

# 解题思路
使用两个栈来实现，一个栈来按顺序存储push进来的数据，另一个用来存出现过的最小值。代码如下:

```java
public class MinStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }
    
    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        int x = s1.pop();
        if (s2.peek() == x) s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
```

需要注意的是上面的Java解法中的pop()中，为什么不能用注释掉那两行的写法，
我之前也不太明白为啥不能对两个stack同时调用peek()函数来比较，
如果是这种写法，那么不管s1和s2对栈顶元素是否相等，永远返回false。
这是为什么呢，这我们就要到Java的对于peek的定义了，对于peek()函数的返回值并不是int类型，
而是一个Object类型，这是一个基本的对象类型，如果我们直接用==来比较的话，那么肯定不会返回true，
因为是两个不同的对象，所以我们一定要先将一个转为int型，然后再和另一个进行比较，
这样才能得到我们想要的答案，这也是Java和C++的一个重要的不同点吧。

那么下面我们再来看另一种解法，这种解法只用到了一个栈，
还需要一个整型变量min_val来记录当前最小值，初始化为整型最小值，
然后如果需要进栈的数字小于等于当前最小值min_val，那么将min_val压入栈，
并且将min_val更新为当前数字。在出栈操作时，先将栈顶元素移出栈，再判断该元素是否和min_val相等，
相等的话我们将min_val更新为新栈顶元素，再将新栈顶元素移出栈即可，参见代码如下：

```java
public class MinStack {
    private int min_val = Integer.MAX_VALUE;
    private Stack<Integer> s = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        if (x <= min_val) {
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if (s.pop() == min_val) min_val = s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min_val;
    }
}
```
