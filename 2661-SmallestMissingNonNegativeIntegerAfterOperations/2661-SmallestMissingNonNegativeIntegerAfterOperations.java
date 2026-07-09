// Last updated: 7/9/2026, 5:08:40 PM
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int res=0;
        int[] rem = new int[value];
        for(int i : nums){
            int r = ((i % value) + value) % value;
            rem[r]++;
        }

        while(rem[res%value]-- > 0) res++;
        return res;
    }
}