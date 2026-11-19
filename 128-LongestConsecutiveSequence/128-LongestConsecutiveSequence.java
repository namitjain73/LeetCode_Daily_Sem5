// Last updated: 11/19/2026, 3:41:59 PM
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        if(nums.length == 0) return 0;
4        Arrays.sort(nums);
5        int ans = 1;
6        int sum = 1;
7        int pre = nums[0];
8        for(int i = 1 ; i < nums.length ; i++){
9            if(pre == nums[i]) continue;
10            else if(pre == nums[i]-1){
11                sum++;
12            }else{
13                sum = 1;
14            }
15            pre = nums[i];
16            ans = Math.max(ans , sum);
17        }
18        return ans;
19    }
20}