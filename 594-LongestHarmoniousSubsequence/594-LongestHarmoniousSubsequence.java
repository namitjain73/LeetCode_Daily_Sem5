// Last updated: 12/19/2025, 9:53:27 PM
1class Solution {
2    public int findLHS(int[] nums) {
3        Arrays.sort(nums);
4        Map<Integer,Integer> map = new HashMap<>();
5        for(int i : nums){
6            map.put(i , map.getOrDefault(i,0)+1);
7        }
8
9        int pre = nums[0];
10        int max = 0;
11        for(int i = 1 ; i < nums.length ; i++){
12            if(nums[i] - pre == 1){
13                max = Math.max(max,map.get(pre)+map.get(nums[i]));
14            }
15            if(pre != nums[i]){
16                pre = nums[i];
17            }
18        }
19        return max;
20        
21    }
22}