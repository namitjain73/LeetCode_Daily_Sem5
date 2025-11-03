// Last updated: 11/3/2025, 1:07:58 PM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = 0 ;
        for(String s : operations){
            if(s.equals("X++") || s.equals("++X")) n++;
            else n--;
        }
        return n;
    }
}