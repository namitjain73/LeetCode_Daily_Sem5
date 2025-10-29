// Last updated: 10/30/2025, 12:54:12 AM
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0;
        long hi = 100000000000000L;
        long ans = -1;
        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            if(possible(mid,time,totalTrips)){
                ans = mid;
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public boolean possible(long mid , int[] time , int tt){
        long t = 0;
        for(int i = 0 ; i < time.length ; i++){
            t += mid / time[i];
            if(t >= tt) return true;

        }
        return t >= tt;
    }
}