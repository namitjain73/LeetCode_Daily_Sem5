// Last updated: 7/9/2026, 5:05:02 PM
class Solution {
    public boolean isArraySpecial(int[] arr) {
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(!((arr[i] % 2 == 0 && arr[i+1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i+1] % 2 == 0))){
                return false;
            }
        }
        return true;
        
    }
}