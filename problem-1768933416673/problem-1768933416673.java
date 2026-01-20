// Last updated: 1/20/2026, 11:53:36 PM
1class Solution {
2    public int[] getGreaterOrSmallerElementIndices(int[] arr, int defaultIndex, boolean isGreater) {
3        int n = arr.length;
4        int[] res = new int[n];
5        Stack<Integer> st = new Stack<>();
6        for(int i = 0; i < n; i++) {
7            int ind =  (defaultIndex == -1) ? i : (n - 1 - i);
8            res[ind] = defaultIndex;
9            while(isGreater && !st.isEmpty() && ((defaultIndex == -1 && arr[st.peek()] < arr[ind]) || (defaultIndex != -1 && arr[st.peek()] <= arr[ind]))) {
10                st.pop();
11            }
12
13            while(!isGreater && !st.isEmpty() && ((defaultIndex == -1 && arr[st.peek()] > arr[ind]) || (defaultIndex != -1 && arr[st.peek()] >= arr[ind]))) {
14                st.pop();
15            }
16
17            if(!st.isEmpty()) {
18                res[ind] = st.peek();
19            }
20            st.push(ind);
21        }
22
23        return res;
24    }
25
26    public long getCount(int left, int right, int ind, int k) {
27        right = Math.min(right, ind + k - 1);
28        int first_ind = Math.max(left, ind - k + 1);
29        int second_ind = Math.max(left, right - k + 1);
30        long count = (ind - second_ind + 1) * (right - ind + 1);
31        if(first_ind < second_ind) {
32            int num = second_ind - first_ind;
33            count += (num * (2*(right - ind) - num + 1)) / 2;
34        }
35        return count;
36    }
37
38    public long minMaxSubarraySum(int[] nums, int k) {
39        int[] prevGreater = getGreaterOrSmallerElementIndices(nums, -1, true);
40        int[] nextGreater = getGreaterOrSmallerElementIndices(nums, nums.length, true);
41        int[] prevSmaller = getGreaterOrSmallerElementIndices(nums, -1, false);
42        int[] nextSmaller = getGreaterOrSmallerElementIndices(nums, nums.length, false);
43        long count = 0;
44        for(int ind = 0; ind < nums.length; ind++) {
45            int left_max = prevGreater[ind] + 1;
46            int right_max = nextGreater[ind] - 1;
47            int left_min = prevSmaller[ind] + 1;
48            int right_min = nextSmaller[ind] - 1;
49
50            right_max = Math.min(right_max, ind + k - 1);
51            right_min = Math.min(right_min, ind + k - 1);
52
53            long count_max = getCount(left_max, right_max, ind, k);
54            long count_min = getCount(left_min, right_min, ind, k);
55            count += (count_max + count_min) * nums[ind];
56        }
57        return count;
58    }
59}