// Last updated: 7/9/2026, 5:20:52 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer , Integer> map = new HashMap<>();
       map.put(0,1);
       int c= 0;

        int sum = 0;

        for(int i : nums){
            sum += i;

            if(map.containsKey( sum - k )){
                c += map.get( sum - k );
            }

            map.put( sum , map.getOrDefault(sum , 0) + 1);
        }
        return c;
    }
}