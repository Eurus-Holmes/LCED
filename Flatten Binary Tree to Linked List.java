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
    TreeNode lastvisited = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode realright = root.right;
        if(lastvisited != null){
            lastvisited.left = null;
            lastvisited.right = root;
        }
        
        lastvisited = root;
        flatten(root.left);
        flatten(realright);
    }
}
