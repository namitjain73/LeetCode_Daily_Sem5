// Last updated: 7/9/2026, 5:19:34 PM
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int j : graph[i]){
                map.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(map , ll , list, visited , 0 , n-1);
        return ll;
    }
    public void dfs(Map<Integer,ArrayList<Integer>> map ,List<List<Integer>> ll,List<Integer> list ,boolean[] visited , int node , int dest){
        if(node == dest){
            ll.add(new ArrayList<>(list));
        }

        visited[node] = true;
        for(int nbrs : map.get(node)){
            if(!visited[nbrs]){
                list.add(nbrs);
                dfs(map , ll , list , visited , nbrs , dest);
                list.remove(list.size()-1);
            }
        }
        visited[node] = false;
    }
}