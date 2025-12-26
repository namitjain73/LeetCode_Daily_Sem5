// Last updated: 12/26/2025, 10:58:10 PM
1class Solution {
2    long f(long h, int l){
3        long rs=h;
4        long o=h;
5        if(l%2==1) o>>=1;
6        while(o>0){
7            rs=(rs<<1)|(o&1);
8            o>>=1;
9        }
10        return rs;
11    }
12    public int countBinaryPalindromes(long n) {
13        int rs=0;
14        int mx=(int) 64-Long.numberOfLeadingZeros(n);
15        for(int i=1; i<=mx; i++){
16            int h=(i+1)/2;
17            long s=1L<<(h-1), e=(1L<<h)-1;
18            long l=f(s, i), r=f(e, i);
19            if(l>n) break;
20            if(r<=n) rs+=(1<<(h-1));
21            else{
22                long a=s, b=e, z=s;
23                while(a<=b){
24                    long m=a+(b-a)/2;
25                    long p=f(m, i);
26                    if(p<=n){
27                        z=m;
28                        a=m+1;
29                    }
30                    else b=m-1;
31                }
32                rs+=(z-s+1);
33            }
34        }
35        return rs+1;
36    }
37}