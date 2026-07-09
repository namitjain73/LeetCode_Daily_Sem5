// Last updated: 7/9/2026, 5:14:40 PM
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int chg0 = 0;
        int chg1 = 0;

        for(int i = 0; i < n; i++){
            char e0 = (i % 2 == 0) ? '0' : '1';
            char e1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != e0) chg0++;
            if(s.charAt(i) != e1) chg1++;
        }

        return Math.min(chg0, chg1);
    }
}