// Last updated: 7/9/2026, 5:10:51 PM
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0l;
        for(int x = 0 ;; x++){
            int val = total-cost1*x;
            if(val < 0) break;
            ans += Math.floor((long)val / (long)cost2)+1;
        }
        return ans;       
    }
}