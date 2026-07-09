// Last updated: 7/9/2026, 5:13:41 PM
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        float[] t = new float[n];
        for (int i=0; i<n; i++){
            t[i] = ((float)(dist[i])/speed[i]);
        }
        Arrays.sort(t);



        int k=0;
        for(int i=0;i <n; i++){
            if(t[i]<= i) break;
            k++;
        }
        return k;
    }
}