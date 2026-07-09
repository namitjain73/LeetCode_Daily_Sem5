// Last updated: 7/9/2026, 5:07:16 PM
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for(int j = nums.size() - x-1 ; j >= 0 ; j--){
            set.add(nums.get(j+x));
            
            Integer low = set.lower(nums.get(j)+1);
            Integer high = set.higher(nums.get(j));
            if(low != null){
                ans = Math.min(ans , Math.abs(low - nums.get(j)));
            }
            if(high != null){
                ans = Math.min(ans , Math.abs(high - nums.get(j)));
            }
        }
        return ans;
    }
}