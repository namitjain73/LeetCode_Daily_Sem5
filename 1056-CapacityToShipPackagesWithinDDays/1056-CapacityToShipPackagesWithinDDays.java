// Last updated: 7/9/2026, 5:18:14 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        int ans = -1;
        // Arrays.sort(weights);

        for(int i = 0 ; i < weights.length ; i++){
            lo = Math.max(lo,weights[i]);
            hi += weights[i];
        }

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(ispossible(weights , days , mid)){
                ans = mid;
                hi = mid - 1 ;
            }else{
                lo = mid + 1;
            }
        }

        return ans;
    }

    public boolean ispossible(int[] weight , int days , int mid){
        int d = 1;
        int w = 0;
        int i =0;
        while(i < weight.length){
            if(w + weight[i] <= mid){
                w += weight[i];
                i++;
            }
            else{
                d++;
                w = 0;
            }
        }
        return d <= days;
    }
}