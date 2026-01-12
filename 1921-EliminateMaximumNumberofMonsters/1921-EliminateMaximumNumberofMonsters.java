// Last updated: 1/12/2026, 11:13:56 PM
1class Solution {
2    public int eliminateMaximum(int[] dist, int[] speed) {
3        int n = dist.length;
4        float[] t = new float[n];
5        for (int i=0; i<n; i++){
6            t[i] = ((float)(dist[i])/speed[i]);
7        }
8        Arrays.sort(t);
9
10
11
12        int k=0;
13        for(int i=0;i <n; i++){
14            if(t[i]<= i) break;
15            k++;
16        }
17        return k;
18    }
19}