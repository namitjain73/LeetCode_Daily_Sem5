// Last updated: 7/9/2026, 5:01:37 PM
class Solution {
    private int[][] dp;
    
    private boolean poss1(List<Integer> v, int i, int t) {
        if (t == 0) 
            return true;
        if (t < 0 || i >= v.size()) 
            return false;
        if (dp[i][t] != -1) 
            return dp[i][t] == 1;
        
        boolean result = poss1(v, i + 1, t) || poss1(v, i + 1, t - v.get(i));
        dp[i][t] = result ? 1 : 0;
        return result;
    }
    
    private boolean poss(List<Integer> v, List<int[]> q, int k) {
        int n = v.size();
        
        for (int i = 0; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (q.get(j)[0] <= i && q.get(j)[1] >= i) 
                    t.add(q.get(j)[2]);
            }
            
            dp = new int[t.size()][10010];
            for (int[] row : dp) Arrays.fill(row, -1);
            
            if (!poss1(t, 0, v.get(i))) 
                return false;
        }
        return true;
    }
    
    public int minZeroArray(int[] v, int[][] q) {
        int n = v.length, m = q.length;
        int l = 0, r = m;
        int ans = m + 10;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (poss(Arrays.stream(v).boxed().toList(), Arrays.asList(q), mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans <= m ? ans : -1;
    }
}