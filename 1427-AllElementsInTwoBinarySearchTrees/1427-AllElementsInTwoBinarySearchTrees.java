// Last updated: 7/9/2026, 5:17:00 PM
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
    public List<Integer> Inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){
                    pred.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }else{
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = Inorder(root1);
        List<Integer> list2 = Inorder(root2);
        List<Integer> list3 = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }
            else{
                list3.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            list3.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            list3.add(list2.get(j));
            j++;
        }

        return list3;

    }
}