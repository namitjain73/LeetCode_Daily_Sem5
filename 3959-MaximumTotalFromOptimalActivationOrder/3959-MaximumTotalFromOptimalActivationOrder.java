// Last updated: 7/9/2026, 4:59:40 PM
class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<value.length; i++){
            arr[i][0] = value[i];
            arr[i][1] = limit[i];
        }
        Arrays.sort(arr, (a,b)->{
            if(b[1] != a[1]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int start = 0;
        int count = 0;
        long ans = 0;
        int i = 0; 

        while(i<n && start < n){
            ans += arr[i][0]; 
            count++;
            int countFix = count;
            while(start < n && countFix >= arr[start][1]){
                start++;
                count--;
                if(count < 0) count = 0;
            }
            i++;
            i = Math.max(start, i);
        }
        
        return ans;
    }
}