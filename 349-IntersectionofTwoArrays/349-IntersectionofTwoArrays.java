// Last updated: 9/4/2025, 2:35:03 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		int n  = nums2.length;
        
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ; i < nums1.length ; i++){
			map.put(nums1[i] , map.getOrDefault(nums1[i],0)+1);
		}
		Set<Integer> set = new HashSet<>();

		
		for(int i = 0 ; i < n ; i++){
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
				set.add(nums2[i]);
				map.put(nums2[i] , map.getOrDefault(nums2[i],0)-1);
			}
		}
        int[] arr = new int[set.size()];
        int i = 0;
		for(int s : set){
            arr[i] = s;
            i++;
		}
		return arr;
    }
}
