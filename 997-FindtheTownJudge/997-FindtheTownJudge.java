// Last updated: 10/30/2025, 12:08:05 AM
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n];
        int[] outdeg = new int[n];
        for(int[] i : trust){
            outdeg[i[0]-1]++;
            indeg[i[1]-1]++;
        }
        for(int i = 0 ; i < n ; i++){
            if(outdeg[i] == 0 && indeg[i] == n-1) return i+1;
        }
        return -1;
    }
}