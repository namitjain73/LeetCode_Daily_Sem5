// Last updated: 7/9/2026, 5:10:19 PM
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n = 0 ;
        int x = 0;
        int[] arr = new int[101];
        for(int i : nums) arr[i]++;
        for(int i : arr){
            n += i/2;
            x += i%2;
        }
        return new int[]{n,x};
        
    }
}