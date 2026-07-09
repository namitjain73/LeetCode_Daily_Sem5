// Last updated: 7/9/2026, 5:22:26 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == Integer.MAX_VALUE) return false;
        int i = 0;
        while(n >= Math.pow(3,i)){
            int pow = (int)Math.pow(3,i);
            if(n == pow) return true;
            i++;
        }
        return false;


    }
}