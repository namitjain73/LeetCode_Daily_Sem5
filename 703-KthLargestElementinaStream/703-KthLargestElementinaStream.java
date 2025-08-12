// Last updated: 8/13/2025, 1:16:59 AM
class KthLargest {
    int k;
    List<Integer> stm;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        stm = new ArrayList<>();
        for(int i : nums){
            stm.add(i);
        }
    }
    
    public int add(int val) {
        stm.add(val);
        Collections.sort(stm);
        return stm.get(stm.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */