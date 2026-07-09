// Last updated: 7/9/2026, 4:58:58 PM
class Solution {
    public int smallestAbsent(int[] nums) {
        int sum =0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            sum += i;
            set.add(i);
        }

        int abs = sum / (nums.length);
        if(abs < 0) abs = 0;
        abs++;
        while(true){
            if(!set.contains(abs)){
                return abs;
            }
            abs++;
        }
    }
}