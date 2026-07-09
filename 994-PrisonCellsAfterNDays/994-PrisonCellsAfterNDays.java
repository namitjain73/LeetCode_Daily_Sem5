// Last updated: 7/9/2026, 5:18:37 PM
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> seen = new HashSet<>();
        boolean hasCycle = false;
        int cycleLength = 0;

        for (int i = 0; i < n; i++) {
            int[] next = new int[8];
            for (int j = 1; j < 7; j++) {
                next[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
            }
            String state = Arrays.toString(next);
            if (seen.contains(state)) { 
                hasCycle = true;
                break;
            } else {
                seen.add(state);
                cycleLength++;
            }
            cells = next;
        }

        if (hasCycle) {
            n = n % cycleLength;
            return prisonAfterNDays(cells, n);
        }
        return cells;
    }
}