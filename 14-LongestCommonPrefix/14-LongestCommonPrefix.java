// Last updated: 7/9/2026, 5:26:03 PM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for(int i = 0 ; i < strs.length ;i++){
            if(len > strs[i].length()){
                len = Math.min(len,strs[i].length());
            }
        }
        String s = "";;
        for(int i = 0 ; i < len ; i++){
            if(ispre(strs,i)){
                s += Character.toString(strs[0].charAt(i));
            }
            if(ispre(strs,i) == false){
                break;
            }
        }
        return s;
        
    }
    public static boolean ispre(String[] arr,int j){
        for(int i = 0 ; i < arr.length ;i++){
            if(arr[0].charAt(j) != arr[i].charAt(j)){
                return false;
            }

        }
        return true;
    }
}