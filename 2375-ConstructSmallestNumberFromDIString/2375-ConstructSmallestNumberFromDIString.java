// Last updated: 5/9/2026, 8:45:19 PM
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
17    Set<Integer> set;
18    public List<Integer> rightSideView(TreeNode root) {
19        set =new HashSet<>();
20        List<Integer> ll = new ArrayList<>();
21        solver(root , 0 , ll);
22        return ll;
23    }
24    public void solver(TreeNode root , int n , List<Integer> ll){
25        if(root == null) return;
26
27        if(!set.contains(n)) {
28            ll.add(root.val);
29            set.add(n);
30        }
31
32
33        solver(root.right , n+1 , ll);
34        solver(root.left , n+1 , ll);
35    }
36}