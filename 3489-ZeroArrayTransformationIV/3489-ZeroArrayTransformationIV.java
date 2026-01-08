// Last updated: 1/8/2026, 11:53:04 PM
1class Solution {
2    private int[][] dp;
3    
4    private boolean poss1(List<Integer> v, int i, int t) {
5        if (t == 0) 
6            return true;
7        if (t < 0 || i >= v.size()) 
8            return false;
9        if (dp[i][t] != -1) 
10            return dp[i][t] == 1;
11        
12        boolean result = poss1(v, i + 1, t) || poss1(v, i + 1, t - v.get(i));
13        dp[i][t] = result ? 1 : 0;
14        return result;
15    }
16    
17    private boolean poss(List<Integer> v, List<int[]> q, int k) {
18        int n = v.size();
19        
20        for (int i = 0; i < n; i++) {
21            List<Integer> t = new ArrayList<>();
22            for (int j = 0; j < k; j++) {
23                if (q.get(j)[0] <= i && q.get(j)[1] >= i) 
24                    t.add(q.get(j)[2]);
25            }
26            
27            dp = new int[t.size()][10010];
28            for (int[] row : dp) Arrays.fill(row, -1);
29            
30            if (!poss1(t, 0, v.get(i))) 
31                return false;
32        }
33        return true;
34    }
35    
36    public int minZeroArray(int[] v, int[][] q) {
37        int n = v.length, m = q.length;
38        int l = 0, r = m;
39        int ans = m + 10;
40        
41        while (l <= r) {
42            int mid = l + (r - l) / 2;
43            if (poss(Arrays.stream(v).boxed().toList(), Arrays.asList(q), mid)) {
44                ans = mid;
45                r = mid - 1;
46            } else {
47                l = mid + 1;
48            }
49        }
50        
51        return ans <= m ? ans : -1;
52    }
53}