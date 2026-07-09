// Last updated: 7/9/2026, 5:26:06 PM
class Solution {
    public boolean isPalindrome(int x) {
        int ans = 0;
        int n = x;
        while(x > 0){
            int rem = x % 10;
            x = x / 10;
            ans = ans*10 + rem;
        }
        if (ans ==  n){
            return true;
        }
        else{
            return false;
        }
    }
}