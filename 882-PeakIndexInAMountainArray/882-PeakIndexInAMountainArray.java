// Last updated: 7/9/2026, 5:19:14 PM
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr[0] > arr[1]) return 0;
        if(arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;
        int lo = 1;
        int hi = arr.length-2;
        while(lo <= hi){
            int mid = lo + ( hi - lo ) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] < arr[mid-1]) hi = mid - 1;
            else if(arr[mid] < arr[mid+1]) lo = mid + 1;
        }
        return -1;
        
    }
}