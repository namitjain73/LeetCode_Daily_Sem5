// Last updated: 7/9/2026, 5:03:32 PM
class Solution {
    public boolean canAliceWin(int n) {
        int ans =0;
        int count = 10;
        while(n >= count){
            n -= count;
            count -=1;
            ans++;
        }
        return ans%2!=0;
        
    }
}