// Last updated: 3/15/2026, 11:34:30 PM
1class NumArray {
2    int[] segTree;
3    int n;
4
5    public NumArray(int[] nums) {
6        n = nums.length;
7        segTree = new int[4 * n];
8        insert(nums, 0, 0, n - 1);
9    }
10
11    public void insert(int[] nums, int i, int l, int r) {
12        if (l == r) {
13            segTree[i] = nums[l];
14            return;
15        }
16
17        int mid = (l + r) / 2;
18        insert(nums, 2 * i + 1, l, mid);
19        insert(nums, 2 * i + 2, mid + 1, r);
20        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
21    }
22
23    public void update(int index, int val) {
24        update1(index, val, 0, 0, n - 1);
25    }
26
27    public void update1(int idx, int v, int i, int l, int r) {
28        if (l == r) {
29            segTree[i] = v;
30            return;
31        }
32
33        int mid = (l + r) / 2;
34        if (idx <= mid) {
35            update1(idx, v, 2 * i + 1, l, mid);
36        } else {
37            update1(idx, v, 2 * i + 2, mid + 1, r);
38        }
39
40        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
41    }
42
43    public int sumRange(int left, int right) {
44        return sum(left, right, 0, 0, n - 1);
45    }
46
47    public int sum(int left, int right, int i, int l, int r) {
48        if (right < l || left > r)
49            return 0;
50        if (left <= l && right >= r)
51            return segTree[i];
52        int mid = (l + r) / 2;
53        return sum(left, right, 2 * i + 1, l, mid) + sum(left, right, 2 * i + 2, mid + 1, r);
54    }
55}
56
57/**
58 * Your NumArray object will be instantiated and called as such:
59 * NumArray obj = new NumArray(nums);
60 * obj.update(index,val);
61 * int param_2 = obj.sumRange(left,right);
62 */