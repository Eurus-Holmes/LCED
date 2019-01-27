# 原题
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

注意点：

  - 无

例子:

```

Input: [1,2,3,null,5,null,4]

Output: [1, 3, 4]

Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
```

# 解题思路
### 递归实现
采用前序遍历。采用 根->右->左 顺序进行遍历，并将每一层的第一个节点添加到结果集中：

```java
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        }
        dfs(root.right, res, level+1);
        dfs(root.left, res, level+1);
    }
}
```

### 非递归实现
层次遍历，每一层都是从左到右遍历，将每一层的最右一个节点添加到结果集中就是我们需要得到的结果：

```java
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while(n-- > 0) {
                root = queue.poll();
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
                if(n == 0) res.add(root.val);  //将该层的最右一个节点添加到结果集中
            }
        }
        return res;
    }
}
```
