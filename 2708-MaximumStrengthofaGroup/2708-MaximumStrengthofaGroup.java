// Last updated: 1/10/2026, 10:47:59 PM
1class Solution {
2    public long maxStrength(int[] nums) {
3        if(nums.length==1) return nums[0];
4        int zero = 0;
5        int neg = 0;
6        int maxNeg = Integer.MIN_VALUE; 
7        long res = 1;
8        boolean hasNonZero = false;
9
10        for (int x : nums) {
11            if (x == 0) {
12                zero++;
13                continue;
14            }
15            res *= x;
16
17            if (x < 0) {
18                neg++;
19                maxNeg = Math.max(maxNeg, x);
20            }
21        }
22        if((neg == 1 && zero+1 == nums.length) || zero==nums.length) res=0;
23        if (neg % 2 == 1) {
24            res /= maxNeg;
25        }
26
27        return res;
28    }
29}
30