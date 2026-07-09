// Last updated: 7/9/2026, 5:07:24 PM
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        boolean f = false;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.contains(i)) set.add(i);
            else {
                if(i != n-1) return false;
                else f = true;
            }
        }
        if(!f) return f;
        for(int i = 1 ; i < n ; i++){
            if(!set.contains(i)) return false;
        }
        return true;
    }
}