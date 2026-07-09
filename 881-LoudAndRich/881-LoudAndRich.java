// Last updated: 7/9/2026, 5:19:16 PM
class Solution {
    int res;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n];
        Map<Integer,ArrayList<Integer>> map= new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i , new ArrayList<>());
        }

        for(int i = 0 ; i < richer.length ; i++){
            int u = richer[i][0];
            int v = richer[i][1];
            map.get(v).add(u);
        }
        Arrays.fill(ans , -1);

        for(int i= 0 ; i < n ; i++){
            solver(map , quiet , i ,ans);
            // if(x != -1) ans[i] = x;
            // else ans[i] = i;
        }
        return ans;
    }
    public int solver(Map<Integer,ArrayList<Integer>> map ,int[] arr , int node , int[] ans){
        
        if(ans[node] != -1) return ans[node];

        int best = node;
        for(int nbrs : map.get(node)){
            int c = solver(map , arr , nbrs,  ans);

            if(arr[c] < arr[best]){
                best = c;
            }
        }
        return ans[node] = best;
    }
}