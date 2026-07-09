// Last updated: 7/9/2026, 5:04:34 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i,0)+1);
        }

        int[] arr= new int[2];
        int k = 0;
        for(int key : map.keySet()){
            if(map.get(key) != 1){
                arr[k] = key;
                k++;
            }
        }
        return arr;
    }
}