// Last updated: 7/9/2026, 5:18:30 PM
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = n-1 ; i >= 2 ; i--){
            int a = nums[i];
            int b = nums[i-1];
            int c = nums[i-2];
            if(a+b > c){
                if(b+c > a){
                    if(a+c > b)
                    return a+b+c;
                }
            }
        }
        return  0;
    }
}