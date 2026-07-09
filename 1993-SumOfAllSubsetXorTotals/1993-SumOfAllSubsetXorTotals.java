// Last updated: 7/9/2026, 5:14:04 PM
class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        findSubsets(nums , 0 , 0);
        return sum;
    }
     public void findSubsets(int[] arr, int index, int ans) {
        if (index == arr.length) {
            sum += ans;
            return;
        }
        findSubsets(arr, index + 1, ans);
        findSubsets(arr, index + 1, arr[index]^ans);
    }
}