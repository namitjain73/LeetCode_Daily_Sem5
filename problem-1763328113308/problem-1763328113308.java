// Last updated: 11/17/2025, 2:51:53 AM
class Solution {
    public boolean winnerOfGame(String s) {
        int a = 0;
        int b = 0;
        int sum = 0;
        int sum2 = 0;
        int n = s.length();
        for(int i = 0 ; i <= n ; i++){
            if(i == n || s.charAt(i) != 'A'){
                a += sum > 2 ? sum-2 : 0;
                sum = 0;
            }else sum++;

            if(i == n || s.charAt(i) != 'B'){
                b += sum2 > 2 ? sum2-2 : 0;
                sum2 = 0;
            }else {
                sum2++;
            }
        }
        if(b >= a) return false;
        return true;

    }
}