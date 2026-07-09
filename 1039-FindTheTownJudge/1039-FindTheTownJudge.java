// Last updated: 7/9/2026, 5:18:21 PM
class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> visited = new HashSet<>();
        int[] count = new int[n+1];

        for(int i = 0 ; i < trust.length ; i++){
            int[] curr = trust[i];
            visited.add(curr[0]);
            count[curr[1]]++;
        }


        for(int i = 1 ; i <= n ; i++){
            if(count[i] == n-1 && !visited.contains(i)) return i;
        }
        return -1;
    }
}