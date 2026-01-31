// Last updated: 1/31/2026, 10:53:05 PM
1class Solution {
2    public int findMinimumTime(List<Integer> strength, int k) {
3        int n =strength.size();
4        return helper(strength,n,k,1,new boolean[n]);
5    }
6
7    int helper(List<Integer> list,int size,int k,int x,boolean[] visited) {
8        if(size==0) return 0;
9        int ans = Integer.MAX_VALUE;
10        for(int i=0;i<list.size();i++) {
11            if(!visited[i]) {
12                int time = (int)Math.ceil((double)list.get(i)/x);
13                visited[i] = true;
14                int next = helper(list,size-1,k,x+k,visited);
15                ans = Math.min(ans,time+next);
16                visited[i] = false;
17            }
18        }
19        return ans;
20    }
21}