// Last updated: 2/24/2026, 12:12:00 PM
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
17    public int sumRootToLeaf(TreeNode root){
18        StringBuilder sb = new StringBuilder();
19        return solver(root , sb);
20    }
21    public int solver(TreeNode root , StringBuilder sb) {
22        if(root == null) return 0;
23        if(root.left == null && root.right == null){
24            sb.append(root.val);
25            int n = number(sb.toString());
26            // System.out.println(n);
27            sb.deleteCharAt(sb.length()-1);
28            return n;
29        }
30
31        int sum = 0;
32        sb.append(root.val);
33        sum += solver(root.left,sb);
34        sum += solver(root.right,sb);
35        sb.deleteCharAt(sb.length()-1);
36        return sum;
37    }
38    public int number(String s){
39        int ans = 0;
40        int c = 1;
41        for(int i = s.length()-1 ; i >= 0 ; i--){
42            if(s.charAt(i) == '1'){
43                ans += c;
44            }
45            c *= 2;
46        }
47        return ans;
48    }
49}