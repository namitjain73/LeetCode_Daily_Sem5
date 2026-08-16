// Last updated: 8/16/2026, 4:17:31 PM
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
17    class Pair{
18        long min = Long.MAX_VALUE;
19        long max = Long.MIN_VALUE;
20        boolean isBST = true;
21    }
22    public boolean isValidBST(TreeNode root) {
23        // if(root.left == null && root.right == null) return true;
24        return solver(root).isBST;
25    }
26    public Pair solver(TreeNode root){
27        if(root == null) return new Pair();
28
29        Pair lst = solver(root.left);
30        Pair rst = solver(root.right);
31        Pair sst = new Pair();
32
33        sst.min = Math.min(root.val , Math.min(lst.min , rst.min));
34        sst.max = Math.max(root.val , Math.max(lst.max , rst.max));
35        sst.isBST = lst.isBST && rst.isBST && root.val > lst.max && root.val < rst.min;
36        return sst;
37    }
38}