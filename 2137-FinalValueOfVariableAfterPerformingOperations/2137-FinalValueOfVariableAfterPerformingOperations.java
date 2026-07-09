// Last updated: 7/9/2026, 5:12:52 PM
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