// Last updated: 10/8/2025, 11:24:06 PM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        int i = 0;
        for(int ele : spells){
            int num = BS(potions,ele,success);
            ans[i++] = num;
        }
        return ans;
    }
    public int BS(int[] arr , int ele , long t){
        int lo = 0;
        int hi = arr.length-1;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(t <= (ele*(long)arr[mid])){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans == -1 ? 0 :arr.length-ans;
    }
}