// Last updated: 10/5/2025, 1:13:55 AM
class Solution {
    public int maxArea(int[] height) {
        return max(height);
        
    }
public static int max(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        int max = 0;
        while(lo <= hi){
            if(max < Math.abs(hi - lo) * Math.min(arr[lo],arr[hi])){
                max = Math.abs(hi - lo) * Math.min(arr[lo],arr[hi]);
            }
           if(arr[lo] < arr[hi]){
            lo++;
           }
           else{
            hi --;
           }
        }
                return max;
        
    }
}