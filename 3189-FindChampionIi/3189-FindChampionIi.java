// Last updated: 7/9/2026, 5:06:52 PM
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] ans = new int[n];
        for(int i = 0 ; i < edges.length ; i++){
            ans[edges[i][1]]++;
        }

        boolean flag = true;
        int x = 0;
        for(int i = 0 ; i < n ; i++){
            if(ans[i] == 0 && flag) {
                flag = false;
                x = i;
            }
            else if(ans[i] == 0) return -1; 
        }
        return x;


    }
}