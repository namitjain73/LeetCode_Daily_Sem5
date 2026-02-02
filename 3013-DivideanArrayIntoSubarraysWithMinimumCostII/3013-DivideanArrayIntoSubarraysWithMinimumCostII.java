// Last updated: 2/3/2026, 2:17:55 AM
1class Solution {
2    static class SmartWindow {
3        int K;
4        TreeMap<Integer, Integer> low = new TreeMap<>();
5        TreeMap<Integer, Integer> high = new TreeMap<>();
6        long sumLow = 0;
7        int szLow = 0, szHigh = 0;
8        SmartWindow(int k){
9            this.K = k;
10        }
11        int windowSize(){
12            return szLow + szHigh;
13        }
14        private void addMap(TreeMap<Integer, Integer> mp, int x){
15            mp.put(x, mp.getOrDefault(x, 0) + 1);
16        }
17        private boolean removeMap(TreeMap<Integer, Integer> mp, int x){
18            Integer c = mp.get(x);
19            if (c == null) return false;
20            if (c == 1) mp.remove(x);
21            else mp.put(x, c - 1);
22            return true;
23        }
24        private int popLast(TreeMap<Integer, Integer> mp){
25            int x = mp.lastKey();
26            removeMap(mp, x);
27            return x;
28        }
29        private int popFirst(TreeMap<Integer, Integer> mp){
30            int x = mp.firstKey();
31            removeMap(mp, x);
32            return x;
33        }
34        void rebalance(){
35            int need = Math.min(K, windowSize());
36            while(szLow > need){
37                int x = popLast(low);
38                szLow --;
39                sumLow -= x;
40                addMap(high, x);
41                szHigh ++;
42            }
43            while(szLow < need && szHigh > 0){
44                int x = popFirst(high);
45                szHigh --;
46                addMap(low, x);
47                szLow ++;
48                sumLow += x;
49            }
50        }
51        void add(int x){
52            if(szLow == 0){
53                addMap(low, x);
54                szLow ++;
55                sumLow += x;
56            }
57            else{
58                int mxLow = low.lastKey();
59                if(x <= mxLow){
60                    addMap(low, x);
61                    szLow ++;
62                    sumLow += x;
63                }
64                else {
65                    addMap(high, x);
66                    szHigh ++;
67                }
68            }
69            rebalance();
70        }
71        void remove(int x){
72            if(removeMap(low, x)){
73                szLow --;
74                sumLow -= x;
75            }
76            else if(removeMap(high, x)){
77                szHigh --;
78            }
79            rebalance();
80        }
81        long query(){
82            return sumLow;
83        }
84    }
85
86    public long minimumCost(int[] nums, int k, int dist) {
87        int n = nums.length;
88        k -= 1;
89        SmartWindow window = new SmartWindow(k);
90
91        for(int i = 1; i <= 1 + dist; i ++){
92            window.add(nums[i]);
93        }
94        long ans = window.query();
95
96        for(int i = 2; i + dist < n; i ++){
97            window.remove(nums[i - 1]);
98            window.add(nums[i + dist]);
99            ans = Math.min(ans, window.query());
100        }
101        return ans + nums[0];
102    }
103}