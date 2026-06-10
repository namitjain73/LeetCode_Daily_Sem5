// Last updated: 6/11/2026, 12:04:05 AM
1class Node{
2    int i, j;
3    long val;
4
5    public Node(int i, int j, long val){
6        this.i = i;
7        this.j = j;
8        this.val = val;
9    }
10}
11
12class Solution {
13    public long maxTotalValue(int[] nums, int k) {
14        int n = nums.length;
15        SegmentTree st = new SegmentTree(nums);
16
17        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
18        for (int i = 0; i < n; i++) {
19            int j = n - 1;
20            int[] res = st.query(i, j);
21            long val = res[1] - res[0];
22            pq.add(new Node(i, j, val));
23        }
24
25        long ans = 0;
26
27        while(k-- > 0){
28            Node peak = pq.poll();
29            ans += peak.val;
30            int i = peak.i;
31            int j = peak.j - 1;
32            if(i <= j){
33                int[] res = st.query(i, j);
34                long val = res[1] - res[0];
35                pq.add(new Node(i, j, val));
36            }
37        }
38
39        return ans;
40    }
41
42}
43
44
45class SegmentTree{
46    Node root;
47
48    public SegmentTree(int[] nums){
49        root = buildTree(nums, 0, nums.length - 1);
50    }
51
52    public int[] query(int start, int end){
53        return query(root, start, end);
54    }   
55
56    private int[] query(Node node, int start, int end){
57        if(node == null){
58            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
59        }
60
61        if(start <= node.start && node.end <= end){
62            return new int[]{node.min, node.max};
63        }
64        if(node.end < start || end < node.start){
65            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
66        }
67        int[] left = query(node.left, start, end);
68        int[] right = query(node.right, start, end);
69        int min = Math.min(left[0], right[0]);
70        int max = Math.max(left[1], right[1]);
71        return new int[]{min, max};
72    }
73
74    private Node buildTree(int[] nums, int start, int end){
75        Node node = new Node(start, end);
76        if(start == end){
77            node.min = nums[start];
78            node.max = nums[start];
79            return node;
80        }
81        int mid = (start + end) / 2;
82        node.left = buildTree(nums, start, mid);
83        node.right = buildTree(nums, mid + 1, end);
84        node.min = Math.min(node.left.min, node.right.min);
85        node.max = Math.max(node.left.max, node.right.max);
86        return node;
87    }
88    
89    private class Node{
90        int start, end;
91        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
92        Node left, right;
93
94        public Node(int start, int end){
95            this.start = start;
96            this.end = end;
97        }
98    }
99}