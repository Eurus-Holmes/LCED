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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        if(minleft==0||minright==0){
            return minleft>minright?minleft+1:minright+1;
        }
        return Math.min(minleft,minright)+1;
    }
}
