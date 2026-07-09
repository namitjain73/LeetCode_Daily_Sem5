// Last updated: 7/9/2026, 5:20:03 PM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int n = letters.length;
        int hi = n-1;
        char ans = letters[0];
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(letters[mid] > target){
                ans = letters[mid];

                hi = mid  - 1;
                
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
        
    }
}