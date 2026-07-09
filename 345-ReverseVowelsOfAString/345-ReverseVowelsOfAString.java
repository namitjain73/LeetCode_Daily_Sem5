// Last updated: 7/9/2026, 5:22:18 PM
class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
        int left = 0;
        int right = s.length()-1;
        char[] ch = s.toCharArray();
        while(left < right){
            while(left < right && !set.contains(ch[left])) left++;
            while(left < right && !set.contains(ch[right])) right--;

            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }    
        return new String(ch);
    }
}