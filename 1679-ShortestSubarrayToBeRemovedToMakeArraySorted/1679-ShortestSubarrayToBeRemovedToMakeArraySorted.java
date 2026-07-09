// Last updated: 7/9/2026, 5:15:30 PM
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int right = n - 1;

        while(right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }

        int min = right;
        if(right == 0) return 0;
        for(int left = 0 ; left < n ; left++){
            if(left > 0 &&  arr[left] < arr[left-1]) break;

            while(right < n && arr[left] > arr[right]){
                right++;
            }

            min = Math.min(min , right - left - 1);
        }
        return min;
    }
}