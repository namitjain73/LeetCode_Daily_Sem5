// Last updated: 7/9/2026, 5:23:12 PM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        return (cheak(nums));
        
    }
    public static boolean cheak(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] == arr[i + 1]){
                return true;
            }
        }
        return false;
    }
}