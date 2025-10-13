// Last updated: 10/14/2025, 12:31:53 AM
class Solution {
    public int integerReplacement(int n) {
        return solver((long)n);
    }
    public int solver(long n){
        if(n == 1){
            return 0;
        }

        int ans = 0;
        if(n % 2 == 0){
            ans = solver(n/2);
        }else{
            ans = Math.min(solver(n-1),solver(n+1));
        }
        return ans+1;
    }
}