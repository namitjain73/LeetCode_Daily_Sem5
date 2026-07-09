// Last updated: 7/9/2026, 5:12:27 PM
class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int ans = 0;
        int n= arr.length;
        for(int i = 0 ;  i < n ; i++){
            if(i <= k) ans += Math.min(arr[i] , arr[k]);
            else ans += Math.min(arr[i] , arr[k] - 1);
        }
        return ans;
    }
}