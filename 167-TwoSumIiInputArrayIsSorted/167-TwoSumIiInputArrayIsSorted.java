// Last updated: 7/9/2026, 5:23:42 PM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr= new int[2];

        for(int i = 0 ; i < numbers.length ; i++){
            int n = ds(numbers , i , target);
            if(n != -1){
                
                arr[0] = Math.min(i,n)+1;
                arr[1] = Math.max(i,n)+1;
                return arr;
            }
        }

        return null;
        
    }

    public int ds(int[] arr , int k , int t){
        int n = t - arr[k];
        int lo = 0;
        int hi = 0;

        if(n < arr[0] || n > arr[arr.length-1]) return -1;
        if(n <= arr[k]){
            lo = 0;
            hi = k-1;
        }
        else{
            lo = k+1;
            hi = arr.length-1;
        }


        while(lo <= hi){
            int mid  = lo + (hi - lo) / 2;
            if(arr[mid] == n){
                return mid;
            }
            else if(arr[mid] > n){
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }
        }

        return -1;
    }
}