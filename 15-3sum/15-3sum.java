// Last updated: 7/9/2026, 5:26:02 PM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ll = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1; i++){
            int lo = i + 1;
            int hi =  nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo]  + nums[hi];
                if(sum == 0){
                    ll.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    lo++;
                    hi--;
                }
                else if(sum < 0){
                    lo++;
                }
                else{
                    hi--;
                }
            }

        }
        return new ArrayList<>(ll);
    }
}