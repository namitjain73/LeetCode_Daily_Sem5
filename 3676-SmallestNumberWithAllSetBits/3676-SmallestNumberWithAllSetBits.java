// Last updated: 7/9/2026, 5:02:42 PM
class Solution {
    public int smallestNumber(int n) {
        int num = 1;
        while(num < n){
            num = (num << 1) + 1;
        }
        return num;
    }
}