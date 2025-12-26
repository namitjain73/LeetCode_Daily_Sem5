// Last updated: 12/26/2025, 9:55:50 PM
1class Solution {
2    public int minAbsoluteDifference(List<Integer> nums, int x) {
3        TreeSet<Integer> set = new TreeSet<>();
4        int ans = Integer.MAX_VALUE;
5
6        for(int j = nums.size() - x-1 ; j >= 0 ; j--){
7            set.add(nums.get(j+x));
8            
9            Integer low = set.lower(nums.get(j)+1);
10            Integer high = set.higher(nums.get(j));
11            if(low != null){
12                ans = Math.min(ans , Math.abs(low - nums.get(j)));
13            }
14            if(high != null){
15                ans = Math.min(ans , Math.abs(high - nums.get(j)));
16            }
17        }
18        return ans;
19    }
20}