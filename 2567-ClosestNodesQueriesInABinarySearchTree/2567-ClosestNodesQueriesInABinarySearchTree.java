// Last updated: 7/9/2026, 5:09:11 PM
class Solution {

    List<Integer> inorderList = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            int floor = findFloor(q);
            int ceil = findCeil(q);

            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
    private int findFloor(int target) {
        int l = 0, r = inorderList.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (inorderList.get(mid) <= target) {
                res = inorderList.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
    private int findCeil(int target) {
        int l = 0, r = inorderList.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (inorderList.get(mid) >= target) {
                res = inorderList.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
