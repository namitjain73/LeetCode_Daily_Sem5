// Last updated: 7/9/2026, 4:58:16 PM
class Solution {
    public int minimumDistance(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i])) continue;
            for(int j = i+1 ; j < n ; j++){
                if(nums[i] == nums[j]){
                    for(int k = j+1 ; k < n ; k++){
                        if(nums[j] == nums[k]){
                            ans = Math.min(ans, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                            // set.add(nums[i]);
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}