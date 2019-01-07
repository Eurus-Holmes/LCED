# 原题
在一棵二叉搜索树上实现一个迭代器，初始化参数为该二叉搜索树的根节点。当调用迭代器的next()方法时，返回该二叉搜索树中最小的元素。

注意点：

  - next()和hasNext()操作的平均时间复杂度为O(1)，空间复杂度为O(n)，n是二叉树的高度

例子:

```
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
```

# 解题思路
要找到二叉搜索树中的最小节点，应该从根节点递归遍历左节点，直到遍历的节点没有左节点，
那么该节点就是二叉树中的最小节点。现在已经有二叉搜索树中没有访问过的最小节点了，
那么当访问了该节点后，剩余没有访问的树中最小的节点在哪里呢？
如果该节点有右子树，那么在它的右子树中(又回到了找一棵二叉搜索树的最小元素，不过这棵二叉搜索树变小了);
如果没有右子树，那么就是它的父节点。
为了能够快速定位到父节点，我们可以用栈将遍历路径暂存起来，
当进行next()操作时，我们弹出栈顶元素并进行访问，如果它有右子树的话就遍历它的右子树；
如果没有右子树，当下次出栈操作时就是访问当前节点的父节点了。

> hasNext()和next()要连用，如i.hasNext(): v.append(i.next())，否则会抛出出栈异常，测试用例提供了这项保证
