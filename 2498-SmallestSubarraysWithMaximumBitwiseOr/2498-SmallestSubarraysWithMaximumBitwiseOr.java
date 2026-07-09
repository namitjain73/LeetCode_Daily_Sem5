// Last updated: 7/9/2026, 5:09:36 PM
class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        for(int i = 0 ; i < n ; i++){
            arr[i] = 1;
            int x = nums[i];
            for(int j = i - 1 ; j >= 0 && (nums[j] | x) != nums[j] ; j--){
                nums[j] |= x;
                arr[j] = i - j + 1;
            }
        }
        return arr;
    }

}