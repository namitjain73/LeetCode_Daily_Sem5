// Last updated: 7/9/2026, 5:20:16 PM
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(n == 1) return true;
        boolean ans = false;
        for(int i = 0 ; i < n;i++){
            if(bits[i] == 1){
                i++;
                ans = false;
            }else{
                ans = true;
            }
        }
        return ans;
    }
}