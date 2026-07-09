// Last updated: 7/9/2026, 5:14:02 PM
class FindSumPairs {
    Map<Integer,Integer> map = new HashMap<>();
    int[] arr1;
    int[] arr2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        for(int x : nums2){
            map.put(x,map.getOrDefault(x,0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(arr2[index],map.get(arr2[index])-1);
        arr2[index] += val;
        map.put(arr2[index],map.getOrDefault(arr2[index],0)+1);
    }
    
    public int count(int tot) {
        int res= 0;
        for(int i : arr1){
            res += map.getOrDefault(tot - i,0);
        }

        return res;
    }
}
