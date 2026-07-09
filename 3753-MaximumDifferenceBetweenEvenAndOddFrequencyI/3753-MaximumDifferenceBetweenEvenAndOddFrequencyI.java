// Last updated: 7/9/2026, 5:02:07 PM
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] % 2 == 0) {
                    minEven = Math.min(minEven, freq[i]);
                } else {
                    maxOdd = Math.max(maxOdd, freq[i]);
                }
            }
        }
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0;
        }
        
        // Return the maximum difference
        return maxOdd - minEven;
    }
}
