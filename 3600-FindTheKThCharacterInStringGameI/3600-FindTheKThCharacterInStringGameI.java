// Last updated: 7/9/2026, 5:04:31 PM
class Solution {
    public char kthCharacter(int k) {
        String bin = Integer.toBinaryString(k-1);
        int c = 0;
        for(char ch : bin.toCharArray()){
            if(ch == '1') c++;
        }

        return (char)('a'+c);
    }
}