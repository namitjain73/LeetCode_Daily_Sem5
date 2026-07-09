// Last updated: 7/9/2026, 5:13:36 PM
class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }

        int res = 0;

        for(char letter : set){
            int left = -1;
            int right = -1;
            for(int i = 0; i < s.length() ; i++){
                if(s.charAt(i) == letter){
                    if(left == -1){
                    left = i;
                    }
                    right = i;
                }
            }

            Set<Character> st = new HashSet<>();
            for(int mid = left+1 ; mid <= right-1 ; mid++){
                st.add(s.charAt(mid));
            }
            res += st.size();
        }
        return res;
    }
}