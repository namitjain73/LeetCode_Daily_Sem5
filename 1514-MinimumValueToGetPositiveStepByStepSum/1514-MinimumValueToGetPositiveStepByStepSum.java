// Last updated: 7/9/2026, 5:16:34 PM
class Solution {
    public int minStartValue(int[] nums) {
        return cheak(nums);
        
    }
    public static int cheak(int[] arr){
        int c = 1;
        int j = 1;
        int n = arr.length;
        // for(int j = 0 ; j < 6 ; j++){
        //     c = j;
        for(int i = 0 ; i < n ; i++){
            c += arr[i];
            if(c <= 0){
                j++;
                c = j;
                i = -1;
                continue;
            }
            
        // }
    }
    return j;
    }
}