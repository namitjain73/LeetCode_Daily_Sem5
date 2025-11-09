// Last updated: 11/9/2025, 8:19:10 AM
class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j=  i+1 ; j < n ; j++){
                if(nums[j] == nums[i]) for(int k = j+1; k < n ; k++){
                    if(nums[j] == nums[k]){
                        min = Math.min(min , Math.abs(i-j)+Math.abs(i-k)+Math.abs(j-k));
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
        
    }
}