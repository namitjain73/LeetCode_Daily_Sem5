// Last updated: 7/9/2026, 5:14:20 PM
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int c = 1;
        int max = 1;
        int n = arr.length;
        if(arr[0] != 1){
            arr[0] = 1;
        }
        for(int i = 1 ; i < n ; i++){
            if(arr[i] - arr[i-1] > 1) arr[i] = arr[i-1]+1;
            max = Math.max(arr[i] , max);
        }
        return max;
    }
}