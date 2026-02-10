// Last updated: 2/11/2026, 2:58:15 AM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int ans = 0;
4        int n = nums.length;
5        for(int i = 0 ; i < n ; i++){
6        Set<Integer> odd = new HashSet<>();
7        Set<Integer> even = new HashSet<>();
8            for(int j = i ; j < n ; j++){
9                if(nums[j] % 2 == 0){
10                    even.add(nums[j]);
11                }else{
12                    odd.add(nums[j]);
13                }
14                if(even.size() == odd.size()){
15                    ans = Math.max(ans , j - i + 1);
16                }
17            }
18        }
19        return ans;
20    }
21}