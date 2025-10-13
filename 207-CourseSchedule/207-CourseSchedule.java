// Last updated: 10/14/2025, 12:40:42 AM
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] e : prerequisites){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indeg[i] == 0){
                q.add(i);
                System.out.println(i);
            }
        }

        int c = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            c++;
            for(int x : adj.get(node)){
                indeg[x]--;
                if(indeg[x] == 0) q.add(x);
            }
        }
        return c == n;
    }
}