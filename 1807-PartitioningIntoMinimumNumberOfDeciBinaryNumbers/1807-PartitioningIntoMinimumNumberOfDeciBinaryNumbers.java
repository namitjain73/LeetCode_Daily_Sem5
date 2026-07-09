// Last updated: 7/9/2026, 5:14:54 PM
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char ch : n.toCharArray()){
            max = Math.max(max , (ch - '0') );
            if(max == 9) break;
        }
        return max;
    }
}