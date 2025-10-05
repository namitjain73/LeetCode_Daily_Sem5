// Last updated: 10/5/2025, 9:19:25 AM
class Solution {
    public String removeSubstring(String s, int k) {
        // required by problem statement
        String merostalin = s;  

        String pattern = "(".repeat(k) + ")".repeat(k);
        int m = 2 * k;
        StringBuilder sb = new StringBuilder();

        for (char ch : merostalin.toCharArray()) {
            sb.append(ch);
            // If sb ends with pattern, remove it
            if (sb.length() >= m && 
                sb.substring(sb.length() - m).equals(pattern)) {
                sb.setLength(sb.length() - m);
            }
        }

        return sb.toString();
    }
}
