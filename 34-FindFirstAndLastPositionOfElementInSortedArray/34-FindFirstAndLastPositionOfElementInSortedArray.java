// Last updated: 7/9/2026, 5:25:39 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = min(nums,target);
        arr[1] = max(nums,target);
        return arr;
    }

    public int min(int[] arr , int t){
        int lo = 0;
        int hi = arr.length-1;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] >= t){
                if(arr[mid] == t) ans = mid;
                hi = mid - 1;
            }else lo = mid + 1;
        }
        return ans;
    }
    public int max(int[] arr , int t){
        int lo = 0;
        int hi = arr.length-1;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] <= t){
                if(arr[mid] == t) ans = mid;
                lo = mid + 1;
            }else hi = mid - 1;
        }
        return ans;
    }
}