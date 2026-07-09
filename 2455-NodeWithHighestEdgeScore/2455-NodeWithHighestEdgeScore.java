// Last updated: 7/9/2026, 5:10:03 PM
class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] ans = new long[n];
        long max = -1;
        for(int i =  0 ; i < n ; i++){
            ans[edges[i]] += i;
            max = Math.max(max,ans[edges[i]]);
        }
        int a = -1;
        for(int i = 0 ; i < n ; i++){
            if(ans[i]== max) return i;
        }
        return -1;
    }
}