// Last updated: 7/9/2026, 5:21:32 PM
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        if(nums[0] != 1){
                arrl.add(1);
                for(int j = 1 ; j < nums[0] - 1 ; j++){
                    arrl.add(1 + j);
                }
            }

        for(int i = 1 ; i < nums.length ; i++){
            
            if(nums[i-1] != nums[i]-1  || nums[i-1] == nums[i]){
                for(int j = 1 ; j < nums[i] - nums[i - 1] ; j++){
                    arrl.add(nums[i-1] + j);
                }
            }
        }



        
        for(int i = 1 ; ; i++){
            if(  nums[nums.length-1]+i <= nums.length){
                arrl.add(nums[nums.length-1]+i);

            }
            else{
                break;
            }
        }
    

        return arrl;
        
    }
}