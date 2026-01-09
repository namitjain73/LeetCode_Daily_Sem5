// Last updated: 1/9/2026, 3:25:18 PM
1class Solution {
2    int max;
3    public int maxEnvelopes(int[][] arr) {
4        if(arr.length ==0) return 0;
5        Arrays.sort(arr , (a,b)->{
6            if(a[0] != b[0]) return a[0]-b[0];
7            return b[1]-a[1];
8        });
9        
10
11        int[] res = new int[arr.length];
12        int len = 0;
13        for(int[] env : arr){
14            int h = env[1];
15
16
17            int idx = Arrays.binarySearch(res , 0 , len , h);
18            if(idx < 0) idx = -idx-1;
19
20
21            res[idx] = h;
22            if(len ==idx) len++;
23        }
24        return len;
25    }
26}