// Last updated: 7/9/2026, 5:17:16 PM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k) - count(nums , k-1);
    }
    public int count(int[] arr , int k){
        int i = 0;
        int res= 0;

        for(int j = 0 ; j < arr.length ; j++){
            if(arr[j] % 2 == 1) k--;

            while(k < 0){
                if(arr[i] % 2 == 1) k++;
                i++;
            }
            res += (j - i) + 1;
        }
        return res;
    }
}