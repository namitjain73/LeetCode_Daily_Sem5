// Last updated: 7/9/2026, 5:17:09 PM
class Solution {
    public int subtractProductAndSum(int n) {
        int p = 1;
        int s = 0;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            p *= rem;
            s += rem ;
            
        }
        p = p - s;
        return p;
        
    }
}