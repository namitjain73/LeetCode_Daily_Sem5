// Last updated: 7/9/2026, 5:19:31 PM
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i , new ArrayList<>());
        }

        int[] indeg = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int j=0; j < graph[i].length ; j++){
                map.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(indeg[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            if(visited.contains(node)) continue;
            visited.add(node);
            ans.add(node);

            for(int i : map.get(node)){
                if(!visited.contains(i)){
                    indeg[i]--;
                    if(indeg[i] == 0) q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;               
    }
}