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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findmax(root,max);
        return max[0];
    }
    
    public int findmax(TreeNode root, int[] max){
        if(root==null)
            return 0;
        
        int left = findmax(root.left,max);
        int right = findmax(root.right,max);
        
        int ans = Math.max(root.val,Math.max(root.val+left, root.val+right));
        
        max[0] = Math.max(max[0],Math.max(ans,root.val+left+right));
        
        return ans;
    }
}
