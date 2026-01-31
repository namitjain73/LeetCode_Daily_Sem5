// Last updated: 1/31/2026, 11:01:48 PM
1class Solution {
2    static int minNonZeroProduct(int p) {
3        long m = 1000000007;
4        long last = (long)(Math.pow(2,p))-1;
5        return (int)(((binaryExpo(last-1,last/2,m)%m)*(last%m))%m);
6    }
7    static long binaryExpo(long a,long b,long m){
8        if(b==0){
9            return 1;
10        }
11        long half = binaryExpo(a,b/2,m);
12        long result = ((half%m) * (half%m))%m;
13        if(b%2 == 1){
14            result = ((result%m)*(a%m))%m;
15        }
16        return result;
17    }
18}