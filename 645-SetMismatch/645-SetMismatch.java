// Last updated: 7/9/2026, 5:20:40 PM
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ;i < nums.length ; i++){
            set.add(nums[i]);
        }
        List<Integer> list2 = new ArrayList<>(set);
        int n = nums[nums.length-1]+1;
        for(int i = 1 ; i < list2.size() ; i++){
            if(list2.get(i-1) != list2.get(i)-1){
                n = list2.get(i)-1;
                break;
            }
        }
        if(nums[0] != 1){
            n  = 1;
        }
        
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[2];
        int j = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] == nums[i]){
                j = nums[i];

            }
        }
        arr[0] = j;
        arr[1] = n;
        return arr;

        
    }
}