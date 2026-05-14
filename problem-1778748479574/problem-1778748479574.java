// Last updated: 5/14/2026, 2:17:59 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length;
4        boolean f = false;
5        Set<Integer> set = new HashSet<>();
6        for(int i : nums){
7            if(!set.contains(i)) set.add(i);
8            else {
9                if(i != n-1) return false;
10                else f = true;
11            }
12        }
13        if(!f) return f;
14        for(int i = 1 ; i < n ; i++){
15            if(!set.contains(i)) return false;
16        }
17        return true;
18    }
19}