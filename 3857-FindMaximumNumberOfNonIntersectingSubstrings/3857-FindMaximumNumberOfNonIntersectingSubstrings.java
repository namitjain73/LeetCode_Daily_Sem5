// Last updated: 7/9/2026, 5:00:50 PM
import java.util.*;

class Solution {
    public int maxSubstrings(String word) {
        int n = word.length();
        List<Integer>[] ci = new ArrayList[26];
        for(int i = 0; i < 26; i++) ci[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ci[word.charAt(i) - 'a'].add(i);
        }

        List<int[]> i = new ArrayList<>();

        for(int k = 0; k < n; k++) {
            char c = word.charAt(k);
            List<Integer> positions = ci[c - 'a'];
            int target = k + 3;
            int idx = Collections.binarySearch(positions, target);
            if(idx < 0) idx = -idx - 1;
            if(idx < positions.size()) {
                int j = positions.get(idx);
                i.add(new int[]{k, j});
            }
        }
        i.sort(Comparator.comparingInt(a -> a[1]));
        int count = 0, lastEnd = -1;
        for(int[] j : i) {
            if(j[0] > lastEnd) {
                count++;
                lastEnd = j[1];
            }
        }

        return count;
    }
}
