/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathlist=new ArrayList<List<Integer>>();
        List<Integer> sumlist = new ArrayList<Integer>();
        pathSumHelper(root,sum,sumlist,pathlist);
        return pathlist;
    }
    public void pathSumHelper(TreeNode root, int sum, List <Integer> sumlist, List<List<Integer>> pathlist){
        if(root==null) 
            return;
        sumlist.add(root.val);
        sum = sum-root.val;
        if(root.left==null && root.right==null){
            if(sum==0){
                pathlist.add(new ArrayList<Integer>(sumlist));
            }
        }else{
            if(root.left!=null)
                pathSumHelper(root.left,sum,sumlist,pathlist);
            if(root.right!=null)
                pathSumHelper(root.right,sum,sumlist,pathlist);
        }
        sumlist.remove(sumlist.size()-1);
    }
}
