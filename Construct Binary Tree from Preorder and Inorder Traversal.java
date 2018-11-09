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
    int preStart = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return helper(0,inorder.length - 1,preorder,inorder);
    }
    
    private TreeNode helper(int inStart, int inEnd, int[] preorder, int[] inorder){
        // Base情况
        if(preStart > preorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inMid = 0;
        // 找到根在中序序列中的位置，从而知道先序中的分割点
        for(int i = inStart ; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                inMid = i;
            }
        }
        preStart++;
        // 例如先序序列 1(234)(567) 中2是左子树的根
        root.left = helper(inStart, inMid - 1, preorder, inorder);
        // 先序序列 1(234)(567) 中5是右子树的根
        root.right = helper(inMid + 1, inEnd, preorder, inorder);
        return root;
    }
}
