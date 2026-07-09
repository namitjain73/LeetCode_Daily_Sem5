// Last updated: 7/9/2026, 5:09:16 PM
class Solution {
    List<List<Integer>> adj;
    int[] bobPath;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        adj = new ArrayList<>();
        int n = edges.length + 1;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        bobPath = new int[n];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> path = new ArrayList<>();
        findBob(path, bob, -1);
        for(int i = 0; i < path.size(); i++){
            bobPath[path.get(i)] = i;
        }
        return score(0, -1, amount, 0, 0);
    }
    private boolean findBob(ArrayList<Integer> path, int node, int parent){
        if(node == 0) return true;
        for(int nbr : adj.get(node)){
            if(nbr != parent){
                path.add(node);
                if(findBob(path, nbr, node)) return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
    private int score(int node, int parent, int[] amount, int time, int curr){
        if(bobPath[node] == -1 || bobPath[node] > time){
            curr += amount[node];
        }
        if(bobPath[node] == time){
            curr += amount[node] / 2;
        }
        if(adj.get(node).size() == 1 && node != 0) return curr;
        int maxScore = Integer.MIN_VALUE;
        for(int nbr : adj.get(node)){
            if(nbr != parent){
                maxScore = Math.max(maxScore, score(nbr, node, amount, time + 1, curr));
            }
        }
        return maxScore;
    }
}