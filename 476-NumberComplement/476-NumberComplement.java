// Last updated: 7/9/2026, 5:21:23 PM
class Solution {
    public int findComplement(int num) {
        int m = num;
        int mask = 0;
        while(m != 0){
            m=m >> 1;
            mask = mask << 1;
            mask = mask | 1;
        }
        int ans = (~num) & mask;
        return ans;

    }
}