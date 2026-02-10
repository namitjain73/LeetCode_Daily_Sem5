// Last updated: 2/11/2026, 2:27:46 AM
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
20        // if(i % 2 == 1){
21
22        // }
23        if(ll.size()-1 < i) ll.add(new ArrayList<>());
24        ll.get(i).add(root.val);
25        solver(root.left,i+1);
26        solver(root.right,i+1);
27    }
28    public void solver1(TreeNode root , int i){
29        if(root == null) return;
30        if(i % 2 == 1){
31            root.val = ll.get(i).remove(ll.get(i).size()-1);
32        }
33        solver1(root.left,i+1);
34        solver1(root.right,i+1);
35    }
36    public TreeNode reverseOddLevels(TreeNode root) {
37        ll = new ArrayList<>();
38        solver(root , 0);
39        solver1(root,0);
40        System.out.println(ll);
41        return root;
42    }
43}