// Last updated: 7/9/2026, 5:25:38 PM
class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums,target);
    }
    public static int search(int[] arr , int t){
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(arr[mid] == t){
                return mid;
            }
            else if(arr[mid] < t){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return cheak(arr,t);
    }
    public static int cheak(int[] arr , int t){
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > t){
                return i;
            }
        }
        return n;
    }
}