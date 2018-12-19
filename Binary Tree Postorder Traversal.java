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
    private List<Integer> resultList = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return resultList;
        }
        Stack<WrapperNode> stack = new Stack<>();
        WrapperNode wrapperNode = new WrapperNode(root, false);
        stack.push(wrapperNode);
        
        while(!stack.isEmpty()){
            while((wrapperNode=stack.peek()).node != null){
                wrapperNode = new WrapperNode(wrapperNode.node.left,false);
                stack.push(wrapperNode);
            }
            
            stack.pop();
            
            wrapperNode = stack.peek();
            
            while(wrapperNode.node != null){
                if(wrapperNode.isFinished){
                    resultList.add(stack.pop().node.val);
                    if(stack.isEmpty()){
                        return resultList;
                    }
                    wrapperNode = stack.peek();
                }
                else{
                    wrapperNode.isFinished = true;
                    wrapperNode = new WrapperNode(wrapperNode.node.right, false);
                    stack.push(wrapperNode);
                    break;
                }
            }
        }
        return resultList;
    }
    
    private static class WrapperNode{
        TreeNode node;
        boolean isFinished;
        
        public WrapperNode(TreeNode node, boolean isFinished){
            this.node = node;
            this.isFinished = isFinished;
        }
    }
}
