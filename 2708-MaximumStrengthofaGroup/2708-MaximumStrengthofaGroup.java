// Last updated: 3/25/2026, 11:13:59 AM
1class Solution {
2    public long maxStrength(int[] nums) {
3        if(nums.length == 1) return nums[0];
4        long res=1;
5        int neg = Integer.MIN_VALUE;
6        int n = nums.length;
7        int zero = 0;
8
9        for(int i= 0 ; i < n  ; i++){
10            if(nums[i] > 0){
11                res *= nums[i];
12            }else if(nums[i] < 0){
13                neg = Math.max(neg , nums[i]);
14                res *= nums[i];
15            }else zero++;
16        }
17
18        if(res < 0) res = res / neg;
19        if(zero ==  n) return 0;
20        if(zero == n-1 && neg != Integer.MIN_VALUE){
21            return 0;
22        }
23        return res;
24    }
25}