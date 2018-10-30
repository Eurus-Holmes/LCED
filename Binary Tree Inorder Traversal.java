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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        //先将最左边的节点都push进栈
        if(root!=null){
            pushAllTheLeft(s, root);
        }
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            res.add(curr.val);
            //如果有右子树，将右节点和右子树的最左边的节点都push进栈
            if(curr.right != null){
                pushAllTheLeft(s, curr.right);
            }
        }
        return res;
    }
    
    private void pushAllTheLeft(Stack<TreeNode> s, TreeNode root){
        s.push(root);
        while(root.left!=null){
            root = root.left;
            s.push(root);
        }
    }
}
