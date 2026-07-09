// Last updated: 7/9/2026, 5:14:49 PM
class Solution {
    public int largestAltitude(int[] gain) {
        
        int n = gain.length;
        int[] arr = new int[n+1];
        arr[0]  = 0;
        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            arr[i] = gain[i-1] + arr[i-1];
            max = Math.max(max , arr[i]);
        }
        return max;
    }
}