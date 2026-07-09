// Last updated: 7/9/2026, 5:24:03 PM
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(int i : mp.keySet()){
            if(mp.get(i) == 1) return i;
        }
        return -1;
    }
}