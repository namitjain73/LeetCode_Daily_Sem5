// Last updated: 7/9/2026, 5:24:25 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode helper(int[] arr , int lo , int hi){
        if(lo > hi) return null;
        if(lo == hi) return new TreeNode(arr[lo]);

        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr,lo,mid-1);
        root.right = helper(arr,mid+1,hi);
        return root;

    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list  = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = list.get(i);
        }
        return helper(arr,0,arr.length-1);
    }
}