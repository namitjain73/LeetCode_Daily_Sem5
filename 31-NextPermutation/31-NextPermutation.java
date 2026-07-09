// Last updated: 7/9/2026, 5:25:42 PM
class Solution {
    public void nextPermutation(int[] nums) {
        int p = -1;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                p = i;
                break;
            }
        }
        if(p == -1){
            reverse(nums,0);
            return;
        }
        int q = -1;
        for(int i = nums.length-1 ; i > p ; i--){
            if(nums[i] > nums[p]){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                break;
                }
        }
        reverse(nums,p+1);
        return;
        
    }
    public static void reverse(int[] arr ,int i){
        int j = arr.length-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}