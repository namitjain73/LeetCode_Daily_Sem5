// Last updated: 10/14/2025, 12:38:45 AM
class Solution {
    public boolean canMeasureWater(int x, int y, int t) {
        if(x+y < t) return false;
        if(x+y == t) return true;
        int k = gcd(x,y);
        return t%k==0;

    }
    public int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}