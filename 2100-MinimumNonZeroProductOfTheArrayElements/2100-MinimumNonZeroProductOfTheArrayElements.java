// Last updated: 7/9/2026, 5:13:19 PM
class Solution {
    static int minNonZeroProduct(int p) {
        long m = 1000000007;
        long last = (long)(Math.pow(2,p))-1;
        return (int)(((binaryExpo(last-1,last/2,m)%m)*(last%m))%m);
    }
    static long binaryExpo(long a,long b,long m){
        if(b==0){
            return 1;
        }
        long half = binaryExpo(a,b/2,m);
        long result = ((half%m) * (half%m))%m;
        if(b%2 == 1){
            result = ((result%m)*(a%m))%m;
        }
        return result;
    }
}