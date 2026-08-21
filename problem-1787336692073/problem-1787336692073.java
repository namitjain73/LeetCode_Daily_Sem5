// Last updated: 8/21/2026, 11:54:52 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    class BST{
18        long max = Long.MIN_VALUE;
19        long min = Long.MAX_VALUE;
20        int sum = 0;
21        int ans = 0;
22        boolean bst = true;
23    }
24    public int maxSumBST(TreeNode root) {
25        return solver(root).ans;
26    }
27    public BST solver(TreeNode root){
28        if(root == null) return new BST();
29
30        BST lst = solver(root.left);
31        BST rst = solver(root.right);
32        BST sst = new BST();
33        sst.max = Math.max(root.val , Math.max(lst.max,rst.max));
34        sst.min = Math.min(root.val , Math.min(lst.min,rst.min));
35        sst.sum = root.val + lst.sum + rst.sum;
36        sst.bst = lst.bst && rst.bst && root.val > lst.max && root.val < rst.min;
37
38        if(sst.bst){
39            sst.ans = Math.max(sst.sum , Math.max(lst.ans,rst.ans));
40        }else{
41            sst.ans = Math.max(lst.ans , rst.ans);
42        }
43        return sst;
44    }
45}