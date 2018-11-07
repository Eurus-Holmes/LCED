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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftmax = maxDepth(root.left);
        int rightmax = maxDepth(root.right);
        return Math.max(leftmax, rightmax)+1;
    }
}
