// Last updated: 7/9/2026, 5:14:26 PM
class Solution {
    public int maxAscendingSum(int[] nums) {
        return sum(nums);
        
    }
    public static int sum(int [] arr){
        int n = arr.length;
        int sum = arr[0];
        int max = arr[0];
        for(int i = 1 ; i < n ; i++){
            if(arr[i - 1] < arr[i]){
                sum += arr[i];
                max = Math.max(max,sum);
            }else{
                sum = arr[i];

            }


        }
        return max;
    }
}