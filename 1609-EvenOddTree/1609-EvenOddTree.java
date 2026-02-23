// Last updated: 2/23/2026, 9:16:26 PM
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
18    public boolean solver(TreeNode root , int i){
19        if(root == null) return true;
20        if(i % 2 == 0 && root.val % 2 == 0) return false;
21        if(i % 2 != 0 && root.val % 2 != 0) return false;
22
23        if(ll.size()-1 < i) ll.add(new ArrayList());
24        //System.out.println(ll + " " + root.val);
25        if(ll.get(i).size() > 0){
26            if(i % 2 != 0){
27                if(ll.get(i).get(ll.get(i).size()-1) <= root.val ) return false;
28            }else{
29                if(ll.get(i).get(ll.get(i).size()-1) >= root.val) return false;
30            }
31        }
32        ll.get(i).add(root.val);
33
34        if(!solver(root.left,i+1)) return false;
35        if(!solver(root.right,i+1)) return false;
36        return true;
37    }
38    public boolean isEvenOddTree(TreeNode root) {
39        ll = new ArrayList<>();
40        // solver(root,0);
41        // System.out.println(ll);
42        return  solver(root , 0);
43        
44    }
45}