// Last updated: 7/9/2026, 5:12:16 PM
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;


        
    }
}