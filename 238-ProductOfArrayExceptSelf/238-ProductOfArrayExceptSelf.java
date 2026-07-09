// Last updated: 7/9/2026, 5:22:51 PM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        return  pre_post_fix(nums);
        
    }

    public static int[] pre_post_fix(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for(int i = 1 ; i < n ; i++){
            left[i] = left[i-1]*arr[i-1];

        }
        right[n-1] = 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            right[i] = right[i+1]*arr[i+1];

        }

        for(int i = 0 ; i < n ; i++){
            left[i] = left[i]*right[i];
        }
        return left;

    }
}