// Last updated: 7/9/2026, 5:21:24 PM
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int lo = 0;
        int hi = (int) 1e9;
        int ans = -1;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(ispossible(houses,heaters,mid)){
                ans = mid;
                hi = mid -  1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] houses , int[] heaters , int r){
        int i = 0;
        int j = 0;
        while(i < houses.length && j < heaters.length){
            if(Math.abs(houses[i] - heaters[j]) <= r) i++;
            else j++;
        }
        return i == houses.length;
    }
}