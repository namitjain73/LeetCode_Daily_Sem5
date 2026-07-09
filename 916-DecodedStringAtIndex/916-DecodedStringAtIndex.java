// Last updated: 7/9/2026, 5:19:03 PM
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size=0;

        for(int i = 0 ; i < s.length() ; i++){
            if(Character.isLetter(s.charAt(i))){
                size += 1;
            }
            else{
                size = size * (s.charAt(i) - '0');
            }
        }

        for(int i =s.length()-1 ; i >= 0 ; i--){
            k = (int)(k % size);
            if(k == 0 && Character.isLetter(s.charAt(i))){
                return Character.toString(s.charAt(i));
            }
            if(Character.isLetter(s.charAt(i))){
                size --;
            }
            else{
                size = size / (s.charAt(i) - '0');
            }
        }
        return "";
    }
}