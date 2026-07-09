// Last updated: 7/9/2026, 5:25:01 PM
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 0 || m >= 0 || c != 0){
            int bita = (n >= 0) ? a.charAt(n--) - '0' : 0;
            int bitb = (m >= 0) ? b.charAt(m--) - '0' : 0;
            int sum = bita + bitb + c;
            c = sum / 2;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }
}