// Last updated: 7/9/2026, 5:12:22 PM
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(int i = arr.length-1 ; i >= nums.length - k  ; i--){
            list.add(arr[i]);
        }

        int[] arr1 = new int[k];
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(list.contains(nums[i])){
                arr1[j] = nums[i];
                list.remove((Integer)nums[i]);
                j++;
            }
        }
        System.out.print(list);
        return arr1;
    }
}