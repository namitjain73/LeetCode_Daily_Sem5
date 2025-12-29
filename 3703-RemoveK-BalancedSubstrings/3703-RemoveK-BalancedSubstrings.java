// Last updated: 12/29/2025, 11:19:32 PM
1class Solution {
2    public String removeSubstring(String s, int k) { 
3        String pattern = "(".repeat(k) + ")".repeat(k);
4        int m = 2 * k;
5        StringBuilder sb = new StringBuilder();
6
7        for (char ch : s.toCharArray()) {
8            sb.append(ch);
9            if (sb.length() >= m && sb.substring(sb.length() - m).equals(pattern)) {
10                sb.setLength(sb.length() - m);
11            }
12        }
13
14        return sb.toString();
15    }
16}
17