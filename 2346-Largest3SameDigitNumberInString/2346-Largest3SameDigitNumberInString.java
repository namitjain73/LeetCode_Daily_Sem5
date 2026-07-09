// Last updated: 7/9/2026, 5:10:59 PM
class Solution {
    public String largestGoodInteger(String num) {
        String s ="";
        int n = 0;
        for(int i = 0 ; i <  num.length()-2 ; i++){
            if(Integer.parseInt(num.substring(i,i+3)) >= n && num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                n = Integer.parseInt(num.substring(i,i+3));
                s = num.substring(i,i+3);
            }
        }
        return s;
        
    }
}