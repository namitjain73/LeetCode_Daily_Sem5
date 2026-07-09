// Last updated: 7/9/2026, 5:19:22 PM
class Solution {
    public String pushDominoes(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'R') left[i] = i;
            else if(s.charAt(i) == 'L') left[i]= -1;
            else if(i == 0 && s.charAt(i) == '.') left[i] = -1;
            else{
                left[i] = left[i-1];
            }
        }

        for(int i = n-1 ; i >= 0 ; i--){
            if(s.charAt(i) == 'L') right[i] = i;
            else if(s.charAt(i) == 'R') right[i]= -1;
            else if(i == n-1 && s.charAt(i) == '.') right[i] = -1;
            else{
                right[i] = right[i+1];
            }
        }

        for(int i = 0 ; i < n ; i++){
            
            int leftdiff = Math.abs(i - left[i]);
            int rightdiff = Math.abs(i - right[i]);
            if(left[i] == -1 && right[i] == -1) sb.append(".");
            else if(left[i] == -1){
                sb.append("L");
            }
            else if(right[i] == -1){
                sb.append("R");
            }else if(leftdiff < rightdiff){
                sb.append("R");
            }else if(leftdiff > rightdiff){
                sb.append("L");
            }else if(leftdiff == rightdiff) sb.append(".");
        }
        return sb.toString();
    }
}