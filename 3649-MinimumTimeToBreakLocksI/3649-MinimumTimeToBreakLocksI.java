// Last updated: 7/9/2026, 5:02:53 PM
class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n =strength.size();
        return helper(strength,n,k,1,new boolean[n]);
    }

    int helper(List<Integer> list,int size,int k,int x,boolean[] visited) {
        if(size==0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++) {
            if(!visited[i]) {
                int time = (int)Math.ceil((double)list.get(i)/x);
                visited[i] = true;
                int next = helper(list,size-1,k,x+k,visited);
                ans = Math.min(ans,time+next);
                visited[i] = false;
            }
        }
        return ans;
    }
}