// Last updated: 7/9/2026, 5:26:11 PM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1 , nums2);
        int median;
        if(arr.length == 0 ) return 0;
        if(arr.length == 1) return arr[0];

        int mid = 0;
        if(arr.length % 2 != 0 ){
            median = (arr.length-1) / 2;
            return Math.round(arr[median] * 100000.0) / 100000.0;
        }
        else{
            median = arr.length / 2;
        }

        double x = (double)arr[median-1] + (double)(arr[median] - arr[median - 1]) / 2; 
        return Math.round(x * 100000.0) / 100000.0;
        
    }

    public int[] merge(int[] a , int [] b){
        int m = a.length;
        int n  = b.length;
        int i = 0;
        int j = 0;;
        int[] arr = new int[m+n];
        int k= 0;

        while(i < m && j < n){
            if(a[i] < b[j]){
                arr[k] = a[i];
                i++;
                k++;
            }
            else{
                arr[k] = b[j];
                j++;
                k++;
            }
        }

        while(i < m){
            arr[k] = a[i];
            i++;
            k++;
        }

        while(j < n){
            arr[k] = b[j];
            j++;
            k++;
        }
        return arr;


    }
}