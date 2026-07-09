// Last updated: 7/9/2026, 5:15:08 PM
class Solution {
    public int maxRepeating(String s, String w) {

        int ans = 0;
        StringBuilder sb = new StringBuilder(w);
        while(s.contains(sb.toString())) {
            ans++;
            sb.append(w);
        }
        return ans;
    }
}