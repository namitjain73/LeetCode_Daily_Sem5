// Last updated: 7/9/2026, 5:16:05 PM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int j = 0;
        for(int i = 0 ; i < 2*n ; i+=2){
            //System.out.println(i);
            ans[i] = nums[j];
            ans[i+1] = nums[j+n];
            j++;
        }
        return ans;
    }
}