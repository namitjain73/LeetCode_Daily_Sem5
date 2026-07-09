// Last updated: 7/9/2026, 5:09:06 PM
class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set=  new HashSet<>();
        for(int i : nums){
            set.add(i);
        }    

        int ans= 0;
        for(int i : set){
            int currcount =0;
            long curr = i;
            while(set.contains((int)curr)){
                currcount++;
                curr = curr*curr;
                if(curr > Integer.MAX_VALUE) break;
                
            }
            ans = Math.max(ans,currcount);
            

        }
        if(ans < 2) return -1;
        return ans;
    }
}