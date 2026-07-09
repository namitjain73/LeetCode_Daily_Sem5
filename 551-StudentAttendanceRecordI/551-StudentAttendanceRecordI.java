// Last updated: 7/9/2026, 5:20:54 PM
class Solution {
    public boolean checkRecord(String s) {
        boolean flag1 = true;
        boolean flag2 = true;

        if(s.contains("LLL")){
            flag1 = false;
        }
        int c = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'A'){
                c++;
            }
        }

        if(c > 1){
            flag2 = false;
        }

        if(flag1 && flag2){
            return true;
        }
        return false;
        
    }
}