// Last updated: 7/9/2026, 5:12:08 PM
class Solution {
    public int maxTotalFruits(int[][] fruits, int p, int k) {
        int n = fruits.length;
        int[] pre_sum = new int[n];
        int[] sorted = new int[n];
        for(int i = 0 ; i < n ; i++){
            sorted[i] = fruits[i][0];
            pre_sum[i] = fruits[i][1] + ((i > 0)? pre_sum[i-1] : 0);

        }

        int max = 0;
        for(int d = 0 ;  d <= k/2 ; d++){
            int rem = k - 2 * d;
            // case 1 for  left
            int i = p - d;
            int j = p + rem;
            int  left = lower_bound(sorted,i);
            int right = upper_bound(sorted,j)-1;
            if(left <= right){
                int tot = pre_sum[right] - ((left > 0) ? pre_sum[left - 1] : 0);
                max = Math.max(max,tot);
            }

            // case2 for right

            i = p - rem;
            j = p + d;
            left = lower_bound(sorted,i);
            right = upper_bound(sorted,j)-1;
            if(left <= right){
                int tot = pre_sum[right] - ((left > 0) ? pre_sum[left - 1] : 0);
                max = Math.max(max,tot);
            }
        }
        return max;
    }
    public int lower_bound(int[] arr , int x){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < x){
                lo = mid + 1;
            }else hi = mid;
        }
        return lo;
    }
    public int upper_bound(int[] arr , int x){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] <= x){
                lo = mid + 1;
            }else hi = mid;
        }
        return lo;
    }
}