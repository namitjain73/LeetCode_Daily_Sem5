// Last updated: 10/29/2025, 11:53:45 PM
class Solution {
    public int smallestNumber(int n) {
        int num = 1;
        while(num < n){
            num = (num << 1) + 1;
        }
        return num;
    }
}