// Last updated: 7/9/2026, 5:10:12 PM
class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                modify(nums,nums[i]);
                n++;
            }
        }
        return n;
        
    }
    public static void modify(int[] arr , int n ){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0){
                arr[i] -= n;
            }
        }
        return;
    }
}