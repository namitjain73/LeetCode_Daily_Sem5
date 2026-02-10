// Last updated: 2/10/2026, 7:14:40 PM
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
17    List<List<Integer>> ll;
18    public void solver(TreeNode root , int i){
19        if(root == null) return;
20
21        if((ll.size()-1) < i) ll.add(new ArrayList());
22        ll.get(i).add(root.val);
23
24        solver(root.left,i+1);
25        solver(root.right , i+1);
26    }
27    public List<List<Integer>> levelOrderBottom(TreeNode root) {
28        ll = new ArrayList<>();
29        solver(root , 0);
30        Collections.reverse(ll);
31        return ll;
32    }
33}