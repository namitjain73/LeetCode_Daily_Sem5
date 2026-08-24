// Last updated: 8/24/2026, 11:53:10 PM
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
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root == null) return null;
19
20
21        if(root.val > key){
22            root.left = deleteNode(root.left , key);
23        }
24        else if(root.val < key){
25            root.right = deleteNode(root.right , key);
26        }
27        else{
28            if(root.left == null) return root.right;
29            else if(root.right == null) return root.left;
30            else{
31                TreeNode min = root.right;
32                while(min.left != null){
33                    min = min.left;
34                }
35                root.val = min.val;
36                root.right = deleteNode(root.right ,min.val);
37            }
38        }
39        return root;
40    }
41}