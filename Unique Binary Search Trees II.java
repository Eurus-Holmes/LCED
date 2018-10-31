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
}
