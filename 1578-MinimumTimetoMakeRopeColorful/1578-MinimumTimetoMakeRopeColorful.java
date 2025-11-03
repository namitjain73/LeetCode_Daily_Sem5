// Last updated: 11/3/2025, 9:13:27 PM
class Solution {
    public int minCost(String s, int[] arr) {
        int sum = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                sum += Math.min(arr[i],arr[i-1]);
                arr[i] = Math.max(arr[i],arr[i-1]);
            }
        }
        return sum;
    }
}