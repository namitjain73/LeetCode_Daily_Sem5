// Last updated: 7/9/2026, 5:09:57 PM
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
    public TreeNode getNode(TreeNode root , int t){
        if(root == null) return null;
        if(root.val == t) return root;

        TreeNode left = getNode(root.left,t);
        TreeNode right = getNode(root.right,t);
        if(left != null) return left;
        return right;
    }
    public void Parents(TreeNode root , Map<TreeNode,TreeNode> p){
        if(root == null) return;
        if(root.left != null) p.put(root.left,root);
        if(root.right != null) p.put(root.right,root);
        Parents(root.left,p);
        Parents(root.right,p);
    }
    public int amountOfTime(TreeNode root, int start) {
        TreeNode infected = getNode(root,start);
        Map<TreeNode ,TreeNode> p  = new HashMap<>();
        Parents(root,p);
        // bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(infected);
        Map<TreeNode ,Integer> v  = new HashMap<>();
        v.put(infected,0);
        while(q.size() > 0){
            int level = v.get(q.peek());
            TreeNode temp = q.remove();
            if(temp.left != null && !v.containsKey(temp.left)){
                v.put(temp.left,level+1);
                q.add(temp.left);
            }
            if(temp.right != null && !v.containsKey(temp.right)){
                v.put(temp.right,level+1);
                q.add(temp.right);
            }
            if(p.containsKey(temp) && !v.containsKey(p.get(temp))){
                v.put(p.get(temp),level+1);
                q.add(p.get(temp));
            }
        }
        int max = -1;
        for(int i : v.values()){
            max = Math.max(max,i);
        }
        return max;
    }
}