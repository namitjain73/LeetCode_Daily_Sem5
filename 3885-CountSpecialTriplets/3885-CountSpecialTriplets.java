// Last updated: 7/9/2026, 5:00:31 PM
class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int max_len = 100001;
        int mod = (int)1e9 + 7;
        int[] right = new int[2*max_len];
        int[] left = new int[2*max_len];
        long count = 0;

        for(int num : nums) right[num]++;


        for(int i = 0 ; i < n ; i++){
            int num_i =  nums[i];
            right[num_i]--;

            int target = 2*num_i;
            if(target <= max_len){
                count += (long)left[target]*right[target];
            }
            left[num_i]++;
        }
        return (int)(count % mod);
    }
}