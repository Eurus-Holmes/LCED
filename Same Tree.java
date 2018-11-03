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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        
        if(p==null&&q!=null)
            return false;
        
        if(p!=null&&q==null)
            return false;
            
        if(p.val!=q.val)
            return false;
        boolean isleftsame = isSameTree(p.left,q.left);
        if(!isleftsame)
            return false;
            
        boolean isrightsame = isSameTree(p.right,q.right);
        if(!isrightsame)
            return false;
        
        return true;
    }
}
