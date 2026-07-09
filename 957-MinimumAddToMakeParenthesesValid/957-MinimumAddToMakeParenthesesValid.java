// Last updated: 7/9/2026, 5:18:47 PM
class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int open = 0;

        for(int i= 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') open++;
            else{
                if(open == 0){
                    count++;
                }
                else{
                    open--;
                }
            }
        }

        return open + count;

    }
}