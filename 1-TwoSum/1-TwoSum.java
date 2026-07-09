// Last updated: 7/9/2026, 5:26:15 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n  = nums.length;

        for(int i = 0 ;  i < n;  i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)) return new int[]{map.get(diff),i};
            map.put(nums[i] , i);
        }
        return new int[]{};
    }
}