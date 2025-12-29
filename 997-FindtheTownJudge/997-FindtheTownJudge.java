// Last updated: 12/30/2025, 2:36:37 AM
1class Solution {
2    public int findJudge(int n, int[][] trust) {
3        Set<Integer> visited = new HashSet<>();
4        int[] count = new int[n+1];
5
6        for(int i = 0 ; i < trust.length ; i++){
7            int[] curr = trust[i];
8            visited.add(curr[0]);
9            count[curr[1]]++;
10        }
11
12
13        for(int i = 1 ; i <= n ; i++){
14            if(count[i] == n-1 && !visited.contains(i)) return i;
15        }
16        return -1;
17    }
18}