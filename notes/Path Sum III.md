# 原题
找到二叉树中从某个顶点向下找的路径中，有多少条等于sum.

注意点：

  - 无

例子：

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

# 解题思路
### DFS + DFS
使用DFS解决。dfs函数有两个参数，一个是当前的节点，另一个是要得到的值。
当节点的值等于要得到的值的时候说明是一个可行的解。再求左右的可行的解的个数，求和之后是所有的。

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if not root: return 0
        return self.dfs(root, sum) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)
    
    def dfs(self, root, sum):
        res = 0
        if not root: return res
        sum -= root.val
        if sum == 0:
            res += 1
        res += self.dfs(root.left, sum)
        res += self.dfs(root.right, sum)
        return res
```

### BFS + DFS
使用BFS找到每个顶点作为起点的情况下，用dfs计算等于sum的路径个数。

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        res = [0]
        que = collections.deque()
        que.append(root)
        while que:
            node = que.popleft()
            if not node:
                continue
            self.dfs(node, res, 0, sum)
            que.append(node.left)
            que.append(node.right)
        return res[0]
    
    def dfs(self, root, res, path, target):
        if not root: return
        path += root.val
        if path == target:
            res[0] += 1
        self.dfs(root.left, res, path, target)
        self.dfs(root.right, res, path, target)
```
