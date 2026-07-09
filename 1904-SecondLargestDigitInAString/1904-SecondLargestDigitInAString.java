// Last updated: 7/9/2026, 5:14:36 PM
class Solution {
    public int secondHighest(String s) {
        int pre = -1;
        int max = Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                if(max < (ch-'0')){
                    pre = max;
                    max = ch-'0';
                }
                else if(ch-'0' < max && ch-'0' > pre){
                    pre = ch-'0';
                }
            }
        }
        return pre == Integer.MIN_VALUE ? -1 : pre;
        
    }
}