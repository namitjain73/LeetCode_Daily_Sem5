// Last updated: 11/9/2025, 8:31:17 AM
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i  : nums) map.put(i , map.getOrDefault(i,0)+1);
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(map.get(nums[i]) < 3) continue;

            int j = get(nums,nums[i],i+1);
            int k = get(nums,nums[i],j+1);
            min = Math.min(min , Math.abs(i-j)+Math.abs(i-k)+Math.abs(j-k));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int get(int[] arr , int t , int idx){
        for(int i = idx ; i < arr.length ; i++){
            if(arr[i] == t){
                return i;
            }
        }
        return -1;
    }
}