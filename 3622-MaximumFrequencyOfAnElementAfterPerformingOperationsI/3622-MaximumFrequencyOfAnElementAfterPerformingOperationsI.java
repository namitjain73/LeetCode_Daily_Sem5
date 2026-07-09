// Last updated: 7/9/2026, 5:03:41 PM
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxEle = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i : nums){
            maxEle=Math.max(maxEle,i);
        }
        int[] freq = new int[maxEle+1];
        for(int i : nums) freq[i]++;
        for(int i = 1 ; i <= maxEle ; i++) freq[i] = freq[i]+freq[i-1];

        int res =0;
        for(int i = 0 ; i <= maxEle ;i++){

            int rightR = Math.min(maxEle,i+k);
            int leftR = Math.max(0,i-k);
            int total = freq[rightR] - (leftR > 0 ? freq[leftR-1]:0);
            int target = freq[i] - (i > 0 ? freq[i-1]:0);
            res = Math.max(res , target + Math.min(total-target,numOperations));
        }
        return res;
    }
}