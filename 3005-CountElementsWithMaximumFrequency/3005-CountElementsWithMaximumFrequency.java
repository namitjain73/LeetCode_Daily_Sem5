// Last updated: 9/22/2025, 4:57:10 PM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            arr[i]++;
            max = Math.max(max,arr[i]);
        }
        int c = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == max) c+=arr[i];
        }

        return c;
    }
}