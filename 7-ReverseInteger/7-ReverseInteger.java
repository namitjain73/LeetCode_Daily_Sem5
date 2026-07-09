// Last updated: 7/9/2026, 5:26:08 PM
class Solution {
    public int reverse(int x) {
        int sum = 0;
        int min = -2147483648;
        int max = 2147483647;
        int m = 1;
        while(x != 0){
            int rem = x % 10;
            x = x / 10;
            if((sum > max/10) || (sum < min/10)){
                return 0;
            }
            sum = sum*10 + rem;

        }
        return sum;
        
    }
}