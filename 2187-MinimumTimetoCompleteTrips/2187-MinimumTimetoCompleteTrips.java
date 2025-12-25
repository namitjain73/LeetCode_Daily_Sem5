// Last updated: 12/26/2025, 4:01:18 AM
1class Solution {
2    public long minimumTime(int[] time, int t) {
3        long lo  =0;
4        long hi = 100000000000000000L;
5        long ans = -1;
6
7        while(lo < hi){
8            long mid = lo + (hi - lo)/2;
9            if(possible(mid , t , time)){
10                hi = mid;
11            }else{
12                lo = mid+ 1L;
13            }
14        }
15        return lo;
16    }
17
18    public boolean possible(long mid , int t , int[] time){
19        long ti = 0;
20        for(int i = 0 ; i < time.length ; i++){
21            ti += mid/time[i];
22            if(ti >= t) return true;
23        }
24        return ti >= t;
25    }
26}