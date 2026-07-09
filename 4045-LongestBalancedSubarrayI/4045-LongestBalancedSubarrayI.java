// Last updated: 7/9/2026, 4:58:41 PM
class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
        Set<Integer> odd = new HashSet<>();
        Set<Integer> even = new HashSet<>();
            for(int j = i ; j < n ; j++){
                if(nums[j] % 2 == 0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                if(even.size() == odd.size()){
                    ans = Math.max(ans , j - i + 1);
                }
            }
        }
        return ans;
    }
}