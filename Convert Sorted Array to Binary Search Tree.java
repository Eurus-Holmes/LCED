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
    public TreeNode buildTree(int[] num, int low, int high){
        if(low>high)
            return null;
        
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num,low,mid-1);
        node.right = buildTree(num,mid+1,high);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
}
