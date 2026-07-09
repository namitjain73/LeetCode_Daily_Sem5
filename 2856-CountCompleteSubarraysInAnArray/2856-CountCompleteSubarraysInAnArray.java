// Last updated: 7/9/2026, 5:07:43 PM
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        int k = (int) Arrays.stream(nums).distinct().count();

        for(int i = 0 ; i < nums.length ; ++i){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size() == k){
                res += nums.length - i;
                map.put(nums[left],map.get(nums[left]) -  1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}