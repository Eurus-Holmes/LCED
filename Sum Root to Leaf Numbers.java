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
    int sumhelper(TreeNode root, int levelBase) {
        if(root == null)
            return 0;
            
        if(root.left == null && root.right == null) {
            return levelBase + root.val; 
        }
        
        int nextLevelBase = (levelBase + root.val)*10 ;
        int leftSubTreeSum = sumhelper(root.left, nextLevelBase);
        int rightSubTreeSum = sumhelper(root.right, nextLevelBase);
    
        return leftSubTreeSum + rightSubTreeSum;
    }
    
    public int sumNumbers(TreeNode root) {
        return sumhelper(root,0);
    }
}
