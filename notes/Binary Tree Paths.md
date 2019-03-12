# 原题
给定一个二叉树，返回所有从根到叶子的路径。

注意点：

  - 无

例子:

```
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

```

# 解题思路
### 思路一
递归实现深度优先遍历。注意要记录途中访问过的节点，遇到叶子节点时可以生成一条路径字符串。
关于记录路径，一般的方法（后面几种思路的方法）是直接将目前为止的路径字符串记录下来，
而下面的代码采用先保存在数组里需要生成路径时再生成的方法，大家可以对照比较一下。


```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        res, path_list = [], []
        self.dfs(root, path_list, res)
        return res

    def dfs(self, root, path_list, res):
        if not root:
            return
        path_list.append(str(root.val))
        if not root.left and not root.right:
            res.append('->'.join(path_list))
        if root.left:
            self.dfs(root.left, path_list, res)
        if root.right:
            self.dfs(root.right, path_list, res)
        path_list.pop()
```

### 思路二
上面的递归定义了一个额外的helper function——dfs()，用于传递和保存递归的信息。其实可以直接用原函数做递归，代码如下。

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        res = []
        if not root:
            return res
        if not root.left and not root.right:
            res.append(str(root.val))
            return res
        for path in self.binaryTreePaths(root.left):
            res.append(str(root.val) + '->' + path)
        for path in self.binaryTreePaths(root.right):
            res.append(str(root.val) + '->' + path)
        return res
```

### 思路三
有递归DFS代码，就可以用栈实现DFS。

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        res, stack = [], [(root, '')]
        while stack:
            node, curs = stack.pop()
            if node:
                if not node.left and not node.right:
                    res.append(curs + str(node.val))
                stack.append((node.left, curs + str(node.val) + '->'))
                stack.append((node.right, curs + str(node.val) + '->'))
        return res
```

### 思路四
同样的，用队列实现BFS也可以完成要求。

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        res, queue = [], [(root, '')]
        while queue:
            node, curs = queue.pop()
            if node:
                if not node.left and not node.right:
                    res.append(curs + str(node.val))
                queue.insert(0, (node.left, curs + str(node.val) + '->'))
                queue.insert(0, (node.right, curs + str(node.val) + '->'))
        return res
```
