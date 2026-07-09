// Last updated: 7/9/2026, 5:21:07 PM
class Solution {
    int ans;
    public int countArrangement(int n) {
        ans =  0;
        List<Integer> list = new ArrayList<>();
        solve(n ,list);
        return ans;
    }
    public void solve(int n , List<Integer> list){
        if(list.size() == n){
            ans++;
            return;
        }

        for(int i = 1 ; i <= n ; i++){
            if(list.contains(i)) continue;
            if((list.size()+1)%i == 0 || i%(list.size()+1)==0){
                list.add(i);
                solve(n,list);
                list.remove(list.size()-1);
            }
        }
    }
}