// Last updated: 7/9/2026, 5:20:49 PM
class Solution {
    public int distributeCandies(int[] can) {
        Set<Integer> set = new HashSet();
        // List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < can.length ; i++){
            set.add(can[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        int n = can.length;
        return Math.min(n/2,list.size());
    }
}