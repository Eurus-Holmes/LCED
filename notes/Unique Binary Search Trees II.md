# 原题
给定1到n这n个数，用它们能够构成多少种形状不同的二叉搜索树。将所有的二叉搜索树罗列出来。

注意点：

  - 这n个数都要是二叉搜索树的节点，不能只取部分

例子：

输入: n = 3

输出:
```

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

# 解题思路
如果只是单纯的计算二叉树的数量，其实这就完全转化成了一道规律题。我们可以从1开始寻找规律。
```
1： 1
1，2： 12， 21
1，2，3：123，132，213，312，321
```

我们可以通过dp的方式来记录。

无论以哪一个节点作为root节点，它的左子树的元素和右子树的元素都是固定的。
也就是说，假设root值为i，那么左子树的元素为[1...i-1],右子树的元素为[i+1...n]。
因此当前root节点可以生成的平衡二叉树数量即为左子树数量*右子树数量。
在这里我们使用int[]数组中下标为n的位置来记录n个元素可以组成的平衡二叉树的数量。

```java
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i==0 || i==1) nums[i] = 1;
            else{
                for(int j = 1 ; j<=i ; j++){
                    nums[i] += nums[j-1]*nums[i-j];
                }
            }
        }
        return nums[n];
    }
```

如果要我们返回具体树的形态的话，
就需要我们通过backtracking的递归形式来找到所有的平衡二叉树。
在递归的过程中，我们找到以当前节点作为根节点的所有平衡二叉树，
并将结果以list形式返回上一级调用。

```java
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start>end){
            result.add(null);
        }else if(start==end){
            result.add(new TreeNode(start));
        }else{
            for(int i = start ; i<=end ; i++){
                List<TreeNode> left = generateTrees(start, i-1);
                List<TreeNode> right = generateTrees(i+1, end);
                for(TreeNode tempLeft : left){
                    for(TreeNode tempRight : right){
                        TreeNode root = new TreeNode(i);
                        root.left = tempLeft;
                        root.right = tempRight;
                        result.add(root);
                    }
                }
            }
            
        }
        return result;
        
    }
```
