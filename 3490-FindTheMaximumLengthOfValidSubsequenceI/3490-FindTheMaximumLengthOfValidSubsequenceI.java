// Last updated: 7/9/2026, 5:04:49 PM
class Solution {
    public int maximumLength(int[] nums) {
        int even= 0;
        int odd = 0;
        int alter = 1;
        int n =  nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 0) even++;
            else odd++;
        }

        even= Math.max(even,odd);

        int parity = nums[0] % 2;
        for(int i = 1 ; i < n ; i++){
            int currparity = nums[i] % 2;
            if(currparity != parity){
                alter++;
                parity = currparity;
            }
        }
        return Math.max(alter,even);
    }
}