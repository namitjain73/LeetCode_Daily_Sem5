// Last updated: 7/9/2026, 5:11:39 PM
class Solution {
    public long minimumTime(int[] time, int t) {
        long lo  =0;
        long hi = 100000000000000000L;
        long ans = -1;

        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            if(possible(mid , t , time)){
                hi = mid;
            }else{
                lo = mid+ 1L;
            }
        }
        return lo;
    }

    public boolean possible(long mid , int t , int[] time){
        long ti = 0;
        for(int i = 0 ; i < time.length ; i++){
            ti += mid/time[i];
            if(ti >= t) return true;
        }
        return ti >= t;
    }
}