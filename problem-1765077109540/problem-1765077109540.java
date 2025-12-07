// Last updated: 12/7/2025, 8:41:49 AM
1class Solution {
2    public int largestPrime(int n) {
3        boolean[] prime = sieve(n);
4        int sum = 0;
5        int ans = 0;
6
7        for(int  i =2 ; i <= n ;i++){
8            if(prime[i]){
9                sum += i;
10                if(sum > n) break;
11                if(isprime(sum)) ans = sum;
12            }
13        }
14
15        return ans;
16    }
17
18    public boolean[] sieve(int n){
19        boolean[]prime = new boolean[n+1];
20        Arrays.fill(prime,true);
21        prime[0] = prime[1] = false;
22        for(int i =2 ; i*i <= n; i++){
23            if(prime[i]){
24                for(int j = i*i ; j <= n ; j+=i){
25                    prime[j] = false;
26                }
27            }
28        }
29        return prime;
30    }
31
32    public boolean isprime(int x){
33        if(x < 2) return false;
34        for(int i = 2 ; i*i <=x ; i++){
35            if(x % i == 0) return false;
36        }
37        return true;
38    }
39
40}