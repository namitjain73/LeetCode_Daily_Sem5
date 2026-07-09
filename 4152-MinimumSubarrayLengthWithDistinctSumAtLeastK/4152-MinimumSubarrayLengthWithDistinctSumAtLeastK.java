// Last updated: 7/9/2026, 4:57:56 PM
class Solution {
    public int minLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int r = 0 ; r <  nums.length ; r++){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);

            if(map.get(nums[r]) == 1){
                sum += nums[r];
            }

            while(sum >= k){
                min = Math.min(min,r - l + 1);

                map.put(nums[l], map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l]) == 0){
                    sum -= nums[l];
                    map.remove(nums[l]);
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}