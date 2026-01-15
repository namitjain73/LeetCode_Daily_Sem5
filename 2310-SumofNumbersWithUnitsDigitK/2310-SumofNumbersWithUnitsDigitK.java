// Last updated: 1/15/2026, 10:51:36 PM
1class Solution {
2    public int minimumNumbers(int num, int k) {
3        if(num==0){
4            return 0;
5        }
6        for(int i=1;i<=10;i++){
7            if((num-(i*k))%10==0 && i * k <= num){
8                return i;
9            }
10        }
11
12        return -1;
13    }
14}