// Last updated: 7/9/2026, 5:05:05 PM
class Solution {
    public int minimumChairs(String s) {
        int sum = 0;
        int max = 0;
        char[] ch = s.toCharArray();
        for(int  i = 0 ; i < ch.length ; i++){
            if(ch[i] == 'E'){
                sum += 1;
            }
            else{
                sum -= 1;
            }
            max = Math.max(max,sum);
        }
        return max;
        
    }
}