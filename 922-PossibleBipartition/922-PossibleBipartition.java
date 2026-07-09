// Last updated: 7/9/2026, 5:18:58 PM
class Pair{
    int vtx;
    int dis;
    public Pair(int vtx , int dis){
        this.vtx = vtx;
        this.dis = dis;
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
    List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
    }

    for (int[] d : dislikes) {
        graph[d[0]].add(d[1]);
        graph[d[1]].add(d[0]);
    }

    HashMap<Integer,Integer> visited = new HashMap<>();
        Queue<Pair> q= new LinkedList<>();

        for(int i = 1 ; i <= n ; i++){
            if(visited.containsKey(i)) continue;
            q.add(new Pair(i,0));
            while(!q.isEmpty()){
                Pair rm = q.poll();

                if(visited.containsKey(rm.vtx)){
                    if(visited.get(rm.vtx) != rm.dis) return false;
                    continue;
                }

                visited.put(rm.vtx , rm.dis);

                for(int nbrs : graph[rm.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new Pair(nbrs,rm.dis+1));
                    }
                }
            }
        }
        return true;
    }
}