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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return left != -1 && right != -1 && Math.abs(left-right)<=1;
    }
    private int findHeight(TreeNode root){
        if(root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right)+1;
    }
}
