// Last updated: 2/2/2026, 11:50:21 PM
1class Solution {
2    public long countNonDecreasingSubarrays(int[] nums, int k) {
3        int n = nums.length;
4        Deque<Node> st = new ArrayDeque<>();
5        int l = n-1;
6        long ans = 0;
7        long cost = 0;
8        for(int i=n-1;i>=0;i--){
9            int cur = 1;
10            while(!st.isEmpty() && st.peekLast().val < nums[i]){
11                Node node = st.pollLast();
12                cur+=node.freq;
13                long cur_cost = (nums[i]-node.val)*node.freq;
14                cost+= cur_cost;
15            }
16            if(!st.isEmpty() && st.peekLast().val==nums[i]){
17                cur += st.peekLast().freq;
18                st.pollLast();
19            }
20            st.addLast(new Node(nums[i],cur));
21            while(!st.isEmpty() && cost>k){
22                Node node = st.pollFirst();
23                int cur_cost = (node.val-nums[l--]);
24                cost-=cur_cost;
25                if(node.freq>1) st.addFirst(new Node(node.val,node.freq-1));
26            }
27
28            if(cost<=k) ans += (l-i+1);
29        }
30
31        return ans;
32    }
33
34    private class Node{
35        int val;
36        long freq;
37        Node(int v,long f){
38            this.val = v;
39            this.freq = f;
40        }
41    }
42}