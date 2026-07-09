// Last updated: 7/9/2026, 5:11:31 PM
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
    public TreeNode createBinaryTree(int[][] des) {
        int n = des.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(des[i][0])){
                map.put(des[i][0],new TreeNode(des[i][0]));
            }
            if(!map.containsKey(des[i][1])){
                map.put(des[i][1] , new TreeNode(des[i][1]));
            }
            set.add(des[i][1]);
        }

        for(int i = 0 ; i < n ; i++){
            if(des[i][2] == 1){
                map.get(des[i][0]).left = map.get(des[i][1]);
            }
            if(des[i][2] == 0){
                map.get(des[i][0]).right = map.get(des[i][1]);
            }
        }

        // System.out.println(set);
        for(int i = 0 ; i < n; i++){
            if(!set.contains(des[i][0])) {
                return map.get(des[i][0]);
            }
        }
        return null;
    }
}