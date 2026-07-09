// Last updated: 7/9/2026, 5:22:30 PM
class NumArray {
    int[] segTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4 * n];
        insert(nums, 0, 0, n - 1);
    }

    public void insert(int[] nums, int i, int l, int r) {
        if (l == r) {
            segTree[i] = nums[l];
            return;
        }

        int mid = (l + r) / 2;
        insert(nums, 2 * i + 1, l, mid);
        insert(nums, 2 * i + 2, mid + 1, r);
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }

    public void update(int index, int val) {
        update1(index, val, 0, 0, n - 1);
    }

    public void update1(int idx, int v, int i, int l, int r) {
        if (l == r) {
            segTree[i] = v;
            return;
        }

        int mid = (l + r) / 2;
        if (idx <= mid) {
            update1(idx, v, 2 * i + 1, l, mid);
        } else {
            update1(idx, v, 2 * i + 2, mid + 1, r);
        }

        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }

    public int sumRange(int left, int right) {
        return sum(left, right, 0, 0, n - 1);
    }

    public int sum(int left, int right, int i, int l, int r) {
        if (right < l || left > r)
            return 0;
        if (left <= l && right >= r)
            return segTree[i];
        int mid = (l + r) / 2;
        return sum(left, right, 2 * i + 1, l, mid) + sum(left, right, 2 * i + 2, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */