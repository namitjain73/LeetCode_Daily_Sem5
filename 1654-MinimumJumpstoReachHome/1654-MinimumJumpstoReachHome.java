// Last updated: 1/6/2026, 9:22:17 PM
1class Pair{
2    int vtx;
3    int block;
4    public Pair(int vtx , int block){
5        this.vtx = vtx;
6        this.block = block;
7    }
8}
9class Solution {
10    public int minimumJumps(int[] forbidden, int a, int b, int x) {
11        int max = 0;
12        HashSet<Integer> set = new HashSet<>();
13        for(int i : forbidden){
14            set.add(i);
15            max = Math.max(max , i);
16        }
17        max = Math.max(max , x) + a + b;
18        Queue<Pair> q = new LinkedList<>();
19        q.add(new Pair(0,0));
20        boolean[][] visited = new boolean[max+1][2];
21        visited[0][0] = true;
22        int step = 0;
23        while(!q.isEmpty()){
24            int size = q.size();
25            while(size-- > 0){
26                Pair rm = q.poll();
27                int st = rm.vtx;
28                int block = rm.block;
29                int fwd = st+a;
30                int bwd = st-b;
31                if(st == x) return step;
32
33                if(fwd <= max && !set.contains(fwd) && !visited[fwd][0]){
34                    visited[fwd][0] = true;
35                    q.add(new Pair(fwd,0));
36                }
37                if(block == 0 && bwd >= 0 && !set.contains(bwd) && !visited[bwd][1]){
38                    visited[bwd][1] = true;
39                    q.add(new Pair(bwd,1));
40                }
41            }
42            step++;
43        }
44        return -1;
45    }
46}