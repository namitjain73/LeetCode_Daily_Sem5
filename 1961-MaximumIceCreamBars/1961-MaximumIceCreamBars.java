// Last updated: 7/9/2026, 5:14:18 PM
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int i = 0;
        int n = costs.length;
        while(i < n && coins > 0){
            if(coins < costs[i]) break;
            coins -=  costs[i];
            i++;
            ans++;
        }
        return ans;
    }
}