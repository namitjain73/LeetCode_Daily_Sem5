// Last updated: 7/9/2026, 5:19:44 PM
class Solution {
    public int search(int[] nums, int target) {
        return binary_search(nums,target);
        
    }

    public static int binary_search(int[] arr ,int item){
        int lo = 0 ;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = (int)(lo + (hi-lo)/2);
            if(arr[mid] ==  item){
                return mid;
            }
            else if(arr[mid] > item){
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }
        }
        return -1;
    }
}