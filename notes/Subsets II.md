# Subset 子集

# Subset I
Given a set of distinct integers, nums, return all possible subsets.

Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

### 深度优先搜索
#### 复杂度
时间 O(NlogN) 空间 O(N) 递归栈空间

#### 思路
这道题可以转化为一个类似二叉树的深度优先搜索。
二叉树的根是个空集，它的左子节点是加上第一个元素产生的集合，右子节点不加上第一个元素所产生的集合。
以此类推，左子节点的左子节点是加上第二个元素，左子节点的右子节点是不加上第二个元素。
而解就是这个二叉树所有的路径，我们要做的就是根据加，或者不加下一元素，来产生一个新的集合，然后继续递归直到终点。
另外需要先排序以满足题目要求。

#### 注意
  - 这里要先排序，不然过不了leetcode，但实际上是不用的
  - 如果递归之前先将空集加入结果，那么递归尽头就不需要再加一次空集。反之则需要。
  - LinkedList在这里效率要高于ArrayList。
  - 新的集合要new一个新的list，防止修改引用。

#### 代码

```java
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        //先加入空集
        res.add(tmp);
        helper(S, 0, res, tmp);
        return res;
    }
    
    private void helper(int[] S,int index,List<List<Integer>> res, List<Integer> tmp){
        if(index>=S.length) return;
        // 不加入当前元素产生的集合，然后继续递归
        helper(S, index+1, res, tmp);
        List<Integer> tmp2 = new ArrayList<Integer>(tmp);
        tmp2.add(S[index]);
        res.add(tmp2);
        // 加入当前元素产生的集合，然后继续递归
        helper(S, index+1, res, tmp2);
    }
}
```

# Subset II
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

### 深度优先搜索
#### 复杂度
时间 O(NlogN) 空间 O(N) 递归栈空间

#### 思路
思路和上题一样，区别在于如果有重复的只能加一次。
好在我们已经先将数组排序（数组中有重复一般都可以用排序解决），所以重复元素是相邻的，
我们为了保证重复元素只加一次，要把这些重复的元素在同一段逻辑中一起处理，而不是在递归中处理，不然就太麻烦了。
所以我们可以先统计好重复的有n个，然后分别在集合中加上0个，1个，2个...n个，然后再分别递归。

#### 代码

```java
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        res.add(tmp);
        helper(nums, res, tmp, 0);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index){
        if(index >= nums.length) return;
        int oldIndex = index;
        //跳过重复元素，重复元素的个数根据index和oldIndex可以得到
        while(index < nums.length - 1 && nums[index] == nums[index+1]) index++;
        helper(nums, res, tmp, index + 1);
        //依次在集合中加入1个、2个...重复的元素
        for(int i = oldIndex; i <= index; i++){
            List<Integer> tmp2 = new ArrayList<Integer>(tmp);
            //这里需要一个循环保证这次加的元素个数
            for(int j = i; j <= index; j++){
                tmp2.add(nums[index]);
            }
            res.add(tmp2);
            helper(nums, res, tmp2, index + 1);
        }
    }
}
```
