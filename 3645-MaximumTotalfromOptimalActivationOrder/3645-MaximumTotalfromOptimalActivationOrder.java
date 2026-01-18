// Last updated: 1/18/2026, 11:12:12 PM
1class Solution {
2    public long maxTotal(int[] value, int[] limit) {
3        int n = value.length;
4        int[][] arr = new int[n][2];
5        for(int i=0; i<value.length; i++){
6            arr[i][0] = value[i];
7            arr[i][1] = limit[i];
8        }
9        Arrays.sort(arr, (a,b)->{
10            if(b[1] != a[1]) return a[1] - b[1];
11            return b[0] - a[0];
12        });
13
14        int start = 0;
15        int count = 0;
16        long ans = 0;
17        int i = 0; 
18
19        while(i<n && start < n){
20            ans += arr[i][0]; 
21            count++;
22            int countFix = count;
23            while(start < n && countFix >= arr[start][1]){
24                start++;
25                count--;
26                if(count < 0) count = 0;
27            }
28            i++;
29            i = Math.max(start, i);
30        }
31        
32        return ans;
33    }
34}