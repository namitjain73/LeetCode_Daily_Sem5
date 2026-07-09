// Last updated: 7/9/2026, 5:13:01 PM
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ;i < n ; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(source);

        while(!q.isEmpty()){
            int node = q.poll();

            if(visited.contains(node)) continue;
            if(node == destination) return true;
            visited.add(node);

            for(int nbrs : map.get(node)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}