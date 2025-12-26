// Last updated: 12/27/2025, 1:18:38 AM
1class Solution {
2    public int countBeautifulPairs(int[] nums) {
3        int ans= 0;
4
5        int n = nums.length;
6        for(int i = 0 ; i < n ; i++){
7            for(int j = i+1 ; j < n ; j ++){
8                if(coprime(nums[i] , nums[j])){
9                    ans++;
10                }
11            }
12        }
13        return ans;
14    }
15    public boolean coprime(int a , int b){
16        a = Integer.toString(a).charAt(0) - '0';
17        b = b % 10;
18        System.out.println(a+ " " + b);
19        int con = Math.max(a,b);
20        for(int i = 2 ; i <= con ; i++){
21            if(a % i == 0 && b % i == 0){
22                return false;
23            }
24        }
25        return true;
26    }
27}