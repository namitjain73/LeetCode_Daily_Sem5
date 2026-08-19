// Last updated: 8/19/2026, 2:10:45 PM
1import java.util.HashMap;
2import java.util.Map;
3
4public class Solution {
5    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
6        Map<Integer, Integer> graph = new HashMap<>();
7        
8        for (int[] seat : reservedSeats) {
9            int row = seat[0];
10            int col = seat[1];
11            if (col >= 2 && col <= 9) {
12                int mask = graph.getOrDefault(row, 0);
13                mask |= (1 << (col - 2));
14                graph.put(row, mask);
15            }
16        }
17        int maxFamilies = 2 * n; 
18        
19        for (int mask : graph.values()) {
20            boolean left = (mask & 15) == 0;
21            boolean right = (mask & 240) == 0;
22            boolean mid = (mask & 60) == 0;
23            
24            maxFamilies -= 2;
25            
26            if (left && right) {
27                maxFamilies += 2;
28            } else if (left || right || mid) {
29                maxFamilies += 1;
30            }
31        }
32        
33        return maxFamilies;
34    }
35}