// Last updated: 12/29/2025, 3:29:32 PM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        int r = grid.length;
4        int c = grid[0].length;
5        int fresh = 0;
6
7        Queue<int[]> q = new LinkedList<>();
8        for(int i = 0 ; i < r ; i++){
9            for(int j = 0 ; j < c ; j++){
10                if(grid[i][j] == 2){
11                    q.add(new int[]{i,j});
12                }
13                else if(grid[i][j] == 1){
14                    fresh++;
15                }
16            }
17        }
18
19        int time = 0;
20        int[] a = {1,-1,0,0};
21        int[] b = {0,0,-1,1};
22
23        while(!q.isEmpty()){
24            int size = q.size();
25            boolean rotten = false;
26
27
28            while(size-- > 0){
29                int[] curr = q.poll();
30                for(int k = 0 ; k < 4 ; k++){
31                    int newx = curr[0] + a[k];
32                    int newy = curr[1] + b[k];
33
34                    if(newx >= 0 && newy >= 0 && newx < r && newy < c && grid[newx][newy] == 1){
35                        fresh--;
36                        q.add(new int[]{newx,newy});
37                        grid[newx][newy] = 2;
38                        rotten = true;
39                    }
40                }
41            }
42            if(rotten) time++;
43        }
44        return fresh == 0 ? time : -1 ;
45
46    }
47}