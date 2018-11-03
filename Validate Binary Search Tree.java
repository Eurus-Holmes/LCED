/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//   Thought1  
class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();  
        pre.add(null);  
        return helper(root, pre);  
    }  
    private boolean helper(TreeNode root, ArrayList<Integer> pre) {  
        if(root == null)  
            return true; 
    
        boolean left = helper(root.left,pre); 
    
        if(pre.get(pre.size()-1)!=null && root.val<=pre.get(pre.size()-1))  
            return false;  
        pre.add(root.val);  
    
        boolean right = helper(root.right,pre);
        return left && right;  
    }
}



//   Thought2
/*   Not Accepted, I temporarily don't know why...
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }  
      
    public boolean isBST(TreeNode node, int low, int high){  
        if(node == null)  
            return true;  
            
        if(low < node.val && node.val < high)
            return isBST(node.left, low, node.val) && isBST(node.right, node.val, high);  
        else  
            return false;  
    }
}
*/
