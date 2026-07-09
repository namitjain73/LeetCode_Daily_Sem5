// Last updated: 7/9/2026, 5:22:37 PM
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(!set.contains(nums[i])) set.add(nums[i]);
            else return nums[i];
        }
        return -1;
    }
}