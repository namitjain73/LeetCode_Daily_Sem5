// Last updated: 7/9/2026, 5:24:49 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        int c = 1;
        int pre = nums[0];
        for(int j = 1; j < n && i < n ; j++){
            System.out.println(i + " " + j);
            if(pre != nums[j]){
                c=1;
                pre = nums[j];
            }
            else if(c == 2){
                continue;
            }
            else if(pre ==  nums[j]) {
                c++;
                // i++;
            }

         nums[i++] = nums[j];
        }

        // for(i = 0 ; i <n ; i++){
        //     System.out.println(nums[i]);
        // }
        return i;
    }
}