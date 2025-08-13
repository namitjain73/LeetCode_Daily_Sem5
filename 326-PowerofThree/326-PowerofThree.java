// Last updated: 8/13/2025, 11:27:46 AM
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