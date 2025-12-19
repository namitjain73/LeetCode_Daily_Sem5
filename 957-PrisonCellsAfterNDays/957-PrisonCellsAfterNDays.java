// Last updated: 12/19/2025, 11:18:05 PM
1class Solution {
2    public int[] prisonAfterNDays(int[] cells, int n) {
3        HashSet<String> seen = new HashSet<>();
4        boolean hasCycle = false;
5        int cycleLength = 0;
6
7        for (int i = 0; i < n; i++) {
8            int[] next = new int[8];
9            for (int j = 1; j < 7; j++) {
10                next[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
11            }
12            String state = Arrays.toString(next);
13            if (seen.contains(state)) { 
14                hasCycle = true;
15                break;
16            } else {
17                seen.add(state);
18                cycleLength++;
19            }
20            cells = next;
21        }
22
23        if (hasCycle) {
24            n = n % cycleLength;
25            return prisonAfterNDays(cells, n);
26        }
27        return cells;
28    }
29}