// Last updated: 1/6/2026, 3:29:52 PM
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
17    public int maxLevelSum(TreeNode root) {
18        Map<Integer , Integer> map= new HashMap<>();
19        int ans = Integer.MIN_VALUE;
20        int res= Integer.MIN_VALUE;
21        solver(root , 1 , map);
22        for(int key : map.keySet()) {
23            if(ans < map.get(key)){
24                ans = map.get(key);
25                res = key;
26            }
27        }
28        return res;
29    }
30    public void solver(TreeNode root ,  int n ,Map<Integer , Integer> map){
31        if(root == null) return;
32        if(!map.containsKey(n)){
33            map.put(n , root.val);
34        }else{
35            map.put(n , map.getOrDefault(n,0)+root.val);
36        }
37
38        solver(root.left , n+1 , map);
39        solver(root.right , n+1,  map); 
40    }
41}