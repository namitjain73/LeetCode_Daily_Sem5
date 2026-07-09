// Last updated: 7/9/2026, 5:25:26 PM
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean arr[] = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        Print(nums,arr,list,ll);
        return ll;
        
    }

    public static void Print(int[] nums, boolean[] arr , List<Integer> list , List<List<Integer>> ll){
        if(nums.length == list.size()){
            ll.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !arr[i - 1]) continue;
            if(!arr[i]){
                arr[i]  = true;
                list.add(nums[i]);
                Print(nums , arr , list , ll);
                arr[i] = false;
                list.remove(list.size()-1);
            }
            
            
        }
        return;
    }
    
    public static boolean ispossible(int[] nums , int val , int n){
        for(int i = n ; i < nums.length ; i++){
            if(nums[i] == val){
                return true;
            }
        }
        return false;
    }
}