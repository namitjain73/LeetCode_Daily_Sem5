// Last updated: 7/9/2026, 5:17:58 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Map<Integer , Integer> map= new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int res= Integer.MIN_VALUE;
        solver(root , 1 , map);
        for(int key : map.keySet()) {
            if(ans < map.get(key)){
                ans = map.get(key);
                res = key;
            }
        }
        return res;
    }
    public void solver(TreeNode root ,  int n ,Map<Integer , Integer> map){
        if(root == null) return;
        if(!map.containsKey(n)){
            map.put(n , root.val);
        }else{
            map.put(n , map.getOrDefault(n,0)+root.val);
        }

        solver(root.left , n+1 , map);
        solver(root.right , n+1,  map); 
    }
}