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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
         LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            else{
                root = stack.pop();
                root = root.right;
            }
        }
        
        return res;
    }
}
