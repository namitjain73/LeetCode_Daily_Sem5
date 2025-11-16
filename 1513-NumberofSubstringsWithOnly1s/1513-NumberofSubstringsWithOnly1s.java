// Last updated: 11/16/2025, 1:23:09 PM
class Solution {
    public int numSub(String s) {
        long sum = 0;
        int l = 0;
        long mod = 1000000007;
        for(int r= 0; r < s.length() ; r++){
            if(s.charAt(r)  == '0'){
                continue;
            }
            if(r > 0 && s.charAt(r-1) == '0') l = r;
            sum = (sum + (r - l + 1 )) % mod;
        }
        return (int)sum;
    }
}