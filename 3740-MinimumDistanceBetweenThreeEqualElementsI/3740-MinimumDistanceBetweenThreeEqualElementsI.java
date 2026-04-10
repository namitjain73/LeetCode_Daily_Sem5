// Last updated: 4/10/2026, 10:19:19 AM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        Set<Integer> set = new HashSet<>();
4
5        int ans = Integer.MAX_VALUE;
6        int n = nums.length;
7
8        for(int i = 0 ; i < n ; i++){
9            if(set.contains(nums[i])) continue;
10            for(int j = i+1 ; j < n ; j++){
11                if(nums[i] == nums[j]){
12                    for(int k = j+1 ; k < n ; k++){
13                        if(nums[j] == nums[k]){
14                            ans = Math.min(ans, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
15                            // set.add(nums[i]);
16                        }
17                    }
18                }
19            }
20        }
21        return ans == Integer.MAX_VALUE ? -1 : ans;
22    }
23}