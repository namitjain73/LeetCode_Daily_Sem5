// Last updated: 7/9/2026, 5:15:10 PM
class Pair{
    int vtx;
    int block;
    public Pair(int vtx , int block){
        this.vtx = vtx;
        this.block = block;
    }
}
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : forbidden){
            set.add(i);
            max = Math.max(max , i);
        }
        max = Math.max(max , x) + a + b;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        boolean[][] visited = new boolean[max+1][2];
        visited[0][0] = true;
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair rm = q.poll();
                int st = rm.vtx;
                int block = rm.block;
                int fwd = st+a;
                int bwd = st-b;
                if(st == x) return step;

                if(fwd <= max && !set.contains(fwd) && !visited[fwd][0]){
                    visited[fwd][0] = true;
                    q.add(new Pair(fwd,0));
                }
                if(block == 0 && bwd >= 0 && !set.contains(bwd) && !visited[bwd][1]){
                    visited[bwd][1] = true;
                    q.add(new Pair(bwd,1));
                }
            }
            step++;
        }
        return -1;
    }
}