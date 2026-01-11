// Last updated: 1/11/2026, 6:28:44 PM
1class Solution {
2    public int minLength(int[] nums, int k) {
3        int min = Integer.MAX_VALUE;
4        int l = 0;
5        int sum = 0;
6        HashMap<Integer,Integer> map = new HashMap<>();
7        for(int r = 0 ; r <  nums.length ; r++){
8            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
9
10            if(map.get(nums[r]) == 1){
11                sum += nums[r];
12            }
13
14            while(sum >= k){
15                min = Math.min(min,r - l + 1);
16
17                map.put(nums[l], map.getOrDefault(nums[l],0)-1);
18                if(map.get(nums[l]) == 0){
19                    sum -= nums[l];
20                    map.remove(nums[l]);
21                }
22                l++;
23            }
24        }
25        return min == Integer.MAX_VALUE ? -1 : min;
26    }
27}