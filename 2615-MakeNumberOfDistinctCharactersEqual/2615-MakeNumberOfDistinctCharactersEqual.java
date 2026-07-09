// Last updated: 7/9/2026, 5:08:49 PM
class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] f1 = getFreq(word1);
        int[] f2 = getFreq(word2);
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (!(f1[i] > 0 && f2[j] > 0)) {
                    continue;
                }
                f1[i]--; f2[i]++;
                f2[j]--; f1[j]++;
                if (areCharsDistinct(f1, f2)) {
                    return true;
                }
                f1[i]++; f2[j]++;
                f1[j]--; f2[i]--;
            }
        }
        
        return false;
    }
    private boolean areCharsDistinct(int[] a, int[] b) {
        int d1 = 0, d2 = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0) d1++;
            if (b[i] > 0) d2++;
        }
        
        return d1 == d2;
    }
    private int[] getFreq(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        
        return f;
    }
}

// TC: O(26 * 26 * 26) => O(1)
// SC: O(26 + 26) => O(1)