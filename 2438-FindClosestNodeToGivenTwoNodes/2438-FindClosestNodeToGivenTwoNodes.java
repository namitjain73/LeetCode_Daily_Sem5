// Last updated: 7/9/2026, 5:10:10 PM
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        solver(node1 , 0 , edges , dist1);
        solver(node2 , 0 , edges , dist2);
        int min = Integer.MAX_VALUE;
        int res = -1;

        for(int i = 0 ;i < n ; i++){
            if(dist1[i] < 0 || dist2[i] < 0 ) continue;
            int max = Math.max(dist1[i] , dist2[i]);
            if(max < min){
                min = max;
                res = i;
            }
        }
        return res;
    }
    public void solver(int curr , int d , int[] edges , int[] dist){
        while(curr != -1 && dist[curr] == -1){
            dist[curr] = d++;
            curr = edges[curr];
        }
    }
}