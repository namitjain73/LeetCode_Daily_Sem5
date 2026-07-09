// Last updated: 7/9/2026, 4:57:57 PM
class Solution {
    public int[] sortByReflection(int[] nums) {
        for(int i= 0 ; i < nums.length ; i ++){
            for(int j = i+1 ; j < nums.length ; j++){
                int r1 = reflect(nums[i]);
                int r2 = reflect(nums[j]);




                if(r1 > r2 || r1 == r2 && nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public int reflect(int n){
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        return Integer.parseInt(sb.toString(),2);
    }
}