// Last updated: 7/9/2026, 5:24:05 PM
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tGas = 0;
        int tCost = 0;
        int n = gas.length;
        for(int i = 0 ; i < n ; i++){
            tGas += gas[i];
            tCost += cost[i];
        }
        if(tCost > tGas) return -1;
        int tank = 0;
        int ans= 0;
        for(int i = 0 ; i <n ; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                ans = i+1;
                tank = 0;
            }
        }
        return ans;
    }
}