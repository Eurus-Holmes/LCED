/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    private Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
		// 先找到第一个节点，并把路径入栈
		while (root != null) {
			stk.push(root);
			root = root.left;
		}
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stk.pop();
		int res = curr.val;
		// 如果该元素有右节点，把它的右节点及右节点的所有左边节点都压入栈中
		curr = curr.right;
		while (curr != null) {
			stk.push(curr);
			curr = curr.left;
		}
		return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // 栈为空时不再有下一个
		return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
