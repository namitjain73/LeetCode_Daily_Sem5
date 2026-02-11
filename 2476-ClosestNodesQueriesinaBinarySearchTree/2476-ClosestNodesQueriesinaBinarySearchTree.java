// Last updated: 2/11/2026, 10:40:10 PM
1class Solution {
2
3    List<Integer> inorderList = new ArrayList<>();
4
5    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
6        inorder(root);
7        List<List<Integer>> ans = new ArrayList<>();
8
9        for (int q : queries) {
10            int floor = findFloor(q);
11            int ceil = findCeil(q);
12
13            ans.add(Arrays.asList(floor, ceil));
14        }
15
16        return ans;
17    }
18    private void inorder(TreeNode root) {
19        if (root == null) return;
20        inorder(root.left);
21        inorderList.add(root.val);
22        inorder(root.right);
23    }
24    private int findFloor(int target) {
25        int l = 0, r = inorderList.size() - 1;
26        int res = -1;
27
28        while (l <= r) {
29            int mid = l + (r - l) / 2;
30
31            if (inorderList.get(mid) <= target) {
32                res = inorderList.get(mid);
33                l = mid + 1;
34            } else {
35                r = mid - 1;
36            }
37        }
38        return res;
39    }
40    private int findCeil(int target) {
41        int l = 0, r = inorderList.size() - 1;
42        int res = -1;
43
44        while (l <= r) {
45            int mid = l + (r - l) / 2;
46
47            if (inorderList.get(mid) >= target) {
48                res = inorderList.get(mid);
49                r = mid - 1;
50            } else {
51                l = mid + 1;
52            }
53        }
54        return res;
55    }
56}
57