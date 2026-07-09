// Last updated: 7/9/2026, 5:17:50 PM
class Solution {
    static int count = 0;
    public int numTilePossibilities(String tiles) {
        count = 0;
        Print(tiles , "");
        return count-1;
    }
    public static void Print(String s , String ans){
        // if(s.length() == 0){
            count++;
            // System.out.println(ans);
            // return;
        // }

        for(int i =0 ;  i < s.length() ; i++){
            if(ispossible(i,s)){
                char ch = s.charAt(i);
                Print(s.substring(0,i) + s.substring(i+1) , ans + ch);
                
            }
        }

        return;
    }
    public static boolean ispossible(int k , String s){
        char ch = s.charAt(k);
        for(int i = k+1 ; i  < s.length() ; i++){
            if(s.charAt(i) == ch){
                return false;
            }
        }
        return true;
    }
}