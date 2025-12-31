// Last updated: 12/31/2025, 10:23:55 PM
1class Pair{
2    int r; 
3    int c;
4    int health;
5    public Pair(int r ,int c, int health){
6        this.r = r;
7        this.c = c;
8        this.health = health;
9    }
10}
11
12class Solution {
13    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
14        int r = grid.size();
15        int c = grid.get(0).size();
16
17        Queue<Pair> q = new LinkedList<>();
18        boolean[][][] visited = new boolean[r][c][health + 1];
19        q.add(new Pair(0,0,health-grid.get(0).get(0)));
20        visited[0][0][health-grid.get(0).get(0)] = true;
21
22        int[] a = {1,-1,0,0};
23        int[] b = {0,0,1,-1};
24        while(!q.isEmpty()){
25            int size = q.size();
26
27            while(size-- > 0){
28                Pair rm = q.poll();
29
30                if(rm.health > 0 && rm.r == r-1 && rm.c == c-1) return true;
31
32                for(int i = 0 ; i < 4; i++){
33                    int nx = rm.r + a[i];
34                    int ny = rm.c + b[i];
35
36                    if(nx >= 0 && ny >= 0 && nx < r && ny < c){
37                        int nh = rm.health - grid.get(nx).get(ny);
38                        if(nh >= 0 && !visited[nx][ny][nh]){
39                            visited[nx][ny][nh] = true;
40                            q.add(new Pair(nx,ny,nh));
41                        }
42                    }
43                }
44            }
45        }
46        return false;
47    }
48}