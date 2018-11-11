/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
            
        h = head;
        
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }   
        return sortedListToBST(0, len - 1);
    }
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.right = right;
 
        return root;
    }
}
