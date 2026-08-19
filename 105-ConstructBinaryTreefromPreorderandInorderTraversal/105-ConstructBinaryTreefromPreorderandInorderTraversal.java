// Last updated: 8/19/2026, 3:23:58 PM
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
17    public TreeNode buildTree(int[] preorder, int[] inorder) {
18        int n = inorder.length;
19        return solver(inorder , 0 , n - 1, preorder , 0 , n - 1);
20    }
21    public TreeNode solver(int[] in , int ini , int inj , int[] pre , int prei , int prej){
22        if(prei > prej || ini > inj) return null;
23
24        TreeNode root = new TreeNode(pre[prei]);
25        int i = ini;
26        while(in[i] != pre[prei]) i++;
27        int len = i - ini;
28        root.left = solver(in , ini , i-1 , pre , prei+1 , prei+len);
29        root.right = solver(in , i+1 , inj , pre , prei+len+1 , prej);
30        return root;
31    }
32}