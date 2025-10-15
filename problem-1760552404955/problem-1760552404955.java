// Last updated: 10/15/2025, 11:50:04 PM
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int max= 0;
        int curr = 1;
        int pre = 0;
        for(int i = 1 ; i< nums.size() ; i++){
            if(nums.get(i) > nums.get(i-1)){
                curr++;
            }else{
                max = Math.max(max,Math.max(curr/2,Math.min(pre,curr)));
                pre = curr;
                curr = 1;
            }
        }

        max = Math.max(max,Math.max(curr/2,Math.min(pre,curr)));
        return max;
    }
}