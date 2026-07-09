// Last updated: 7/9/2026, 4:58:49 PM
class Solution {
    public String removeSubstring(String s, int k) { 
        String pattern = "(".repeat(k) + ")".repeat(k);
        int m = 2 * k;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= m && sb.substring(sb.length() - m).equals(pattern)) {
                sb.setLength(sb.length() - m);
            }
        }

        return sb.toString();
    }
}
