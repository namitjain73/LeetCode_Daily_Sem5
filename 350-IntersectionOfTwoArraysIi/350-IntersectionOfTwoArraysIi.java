// Last updated: 7/9/2026, 5:22:15 PM
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i < nums2.length ; i++){
            list.add(nums2[i]);
        }

        for(int i = 0; i < nums1.length ; i++){
            for(int j = 0 ; j < list.size() ; j++){
                if(nums1[i] == list.get(j)){
                    list2.add(nums1[i]);
                    list.remove(j);
                    break;
                }
            }
        }
        int[] arr = new int[list2.size()];
        for(int i = 0 ; i < list2.size() ; i++){
            arr[i] = list2.get(i);
        }
        return arr;
        
    }
}