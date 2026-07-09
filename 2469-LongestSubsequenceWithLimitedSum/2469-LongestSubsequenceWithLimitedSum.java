// Last updated: 7/9/2026, 5:09:54 PM
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = 0;
        for(int i = 0 ; i < nums.length ; i++){
            n += nums[i];
            nums[i] = n;
        }
        for(int i = 0 ; i < queries.length ; i++){
            queries[i] = position(queries[i],nums);
        }
        return queries;

    }

    public static int position(int n , int[] arr){
        int lo = 0 ; 
        int ans = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/ 2;
            if(arr[mid] <= n){
                ans = lo;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}