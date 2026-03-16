// Last updated: 3/17/2026, 2:54:54 AM
1class Solution {
2    public int[] getBiggestThree(int[][] grid) {
3        int m=grid.length;
4        int n=grid[0].length;
5        TreeSet<Integer> ts=new TreeSet<>((a,b)->Integer.compare(b,a));
6        for(int i=0;i<m;i++){
7            for(int j=0;j<n;j++){
8                ts.add(grid[i][j]);
9                for(int size=1;size<=Math.min(m,n);size++){
10                    int sum=0;
11                    boolean valid=true;
12                    int x1=i,y1=j,x2=i,y2=j;
13                    int dir1=-1,dir2=1;
14                    int temp=0;
15                    while(temp<=2*size){
16                        if(Math.min(x1,x2)<0||Math.max(x1,x2)>=m||Math.min(y1,y2)<0||Math.max(y1,y2)>=n){
17                            valid=false;
18                            break;
19                        }
20                        if(x1==x2&&y1==y2){
21                            sum+=grid[x1][y1];
22                        }else{
23                            sum+=grid[x1][y1];
24                            sum+=grid[x2][y2];
25                        }
26                        if(temp==size){
27                            dir2=dir2*dir1;
28                            dir1=dir2*dir1;
29                        }
30                        x1--;
31                        x2--;
32                        y1=y1+dir1;
33                        y2=y2+dir2;
34                        temp++;
35                    }
36                    if(valid){
37                        ts.add(sum);
38                    }
39                }
40            }
41        }
42        List<Integer> lst=new ArrayList<>();
43        while(!ts.isEmpty()&&lst.size()<3){
44            lst.add(ts.getFirst());
45            ts.removeFirst();
46        }
47        return lst.stream().mapToInt(Integer::intValue).toArray();
48    }
49}