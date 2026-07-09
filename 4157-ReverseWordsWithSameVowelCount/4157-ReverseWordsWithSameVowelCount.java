// Last updated: 7/9/2026, 4:57:53 PM
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int v = vowel_count(arr[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for(int i = 1 ; i < arr.length ; i++){
            sb.append(" ");
            if(vowel_count(arr[i]) == v){
                sb.append(reverse(arr[i]));
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public int vowel_count(String s){
        int v = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch== 'u') v++;
        }
        return v;
    }
}