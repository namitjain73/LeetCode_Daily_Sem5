// Last updated: 7/9/2026, 5:07:59 PM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = 0;
        for(int x : derived){
            n ^= x;
        }

        return n == 0;
        
    }
}