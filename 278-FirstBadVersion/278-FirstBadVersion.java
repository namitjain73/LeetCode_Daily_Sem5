// Last updated: 7/9/2026, 5:22:40 PM
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return bad_version(n);
        
    }

    public int bad_version(int arr){
        int lo = 0;
        int hi = arr;
        int ans =0 ;
        while(lo <= hi){
            int mid = lo+((hi-lo)/2);
            if(isBadVersion(mid) == true){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return  ans;
    }
}