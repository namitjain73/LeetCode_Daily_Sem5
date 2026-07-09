// Last updated: 7/9/2026, 5:17:49 PM
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int t, MountainArray mountainArr) {
        int peekidx = peek(mountainArr);

        int n = BS(mountainArr , 0 , peekidx,t);
        if(n != -1) return n;
        int m = BS1(mountainArr , peekidx, mountainArr.length()-1,t);
        return m;
        
    }

    public static int BS(MountainArray arr , int si , int ei,int t){
        while(si <= ei){
            int mid = si + (ei - si)/2;
            if(arr.get(mid) == t) return mid;
            else if(arr.get(mid) > t) ei = mid - 1;
            else si = mid + 1;
        }
        return -1;
    }

    public static int BS1(MountainArray arr , int si , int ei,int t){
        while(si <= ei){
            int mid = si + (ei - si)/2;
            if(arr.get(mid) == t) return mid;
            else if(arr.get(mid) < t) ei = mid - 1;
            else si = mid + 1;
        }
        return -1;
    }

    public static int peek(MountainArray arr) {
        if(arr.get(0) > arr.get(1)) return 0;
        if(arr.get(arr.length()-1) > arr.get(arr.length()-2)) return arr.length()-1;
        int lo = 1;
        int hi = arr.length()-2;
        while(lo <= hi){
            int mid = lo + ( hi - lo ) / 2;
            int curr = arr.get(mid);
            int pre = arr.get(mid-1);
            int post = arr.get(mid + 1);
            if(curr > pre && curr > post) return mid;
            else if(curr < pre) hi = mid - 1;
            else if(curr < post) lo = mid + 1;
        }
        return -1;
        
    }
}