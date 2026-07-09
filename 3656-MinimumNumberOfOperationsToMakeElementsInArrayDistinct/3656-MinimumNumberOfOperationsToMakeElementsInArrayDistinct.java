// Last updated: 7/9/2026, 5:02:44 PM
class Solution {
    public int minimumOperations(int[] nums) {
        if(ispossible(nums,0)) return 0;
        int ans = 1;
        for(int i = 3 ; i < nums.length ;){
            if(i+3 > nums.length-1){
                if(ispossible(nums,i)){
                    return ans;
                }
                else{
                    return ans + 1;
                }

            }
            if(!ispossible(nums,i)){
                i += 3;
                ans ++;
            }
            else{
                return ans;
            }

        }
        return ans;
        
    }
    public static boolean ispossible(int[] arr , int j){
        Set<Integer> set = new HashSet<>();
        for(int i = j ; i < arr.length ; i++){
            set.add(arr[i]);
        }

        return set.size() == (arr.length - j);
    }
}