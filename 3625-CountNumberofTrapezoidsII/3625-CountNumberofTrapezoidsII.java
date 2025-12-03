// Last updated: 12/4/2025, 3:26:00 AM
1class Solution {
2    public int countTrapezoids(int[][] points) {
3        int n = points.length;
4        
5        HashMap<Integer, HashMap<Integer, Integer>> segments = new HashMap<>();
6        HashMap<Integer, HashMap<Integer, Integer>> parallel_segments = new HashMap<>();
7
8        for (int i = 0; i < n; i++) {
9            for (int j = i + 1; j < n; j++) {
10                int dx = points[j][0] - points[i][0];
11                int dy = points[j][1] - points[i][1];
12                
13                if (dx < 0 || (dx == 0 && dy < 0)) {
14                    dx = -dx;
15                    dy = -dy;
16                }
17                
18                int g = gcd(dx, Math.abs(dy));
19                int sx = dx / g;
20                int sy = dy / g;
21                
22                int line_param = sx * points[i][1] - sy * points[i][0];
23                
24                int key_normalized = (sx << 12) | (sy + 2000);
25                int key_full = (dx << 12) | (dy + 2000);
26                
27                segments.computeIfAbsent(key_normalized, k -> new HashMap<>())
28                       .merge(line_param, 1, Integer::sum);
29                parallel_segments.computeIfAbsent(key_full, k -> new HashMap<>())
30                                .merge(line_param, 1, Integer::sum);
31            }
32        }
33        
34        return calculate(segments) - calculate(parallel_segments) / 2;
35    }
36    
37    private int calculate(HashMap<Integer, HashMap<Integer, Integer>> map) {
38        long result = 0;
39        
40        for (HashMap<Integer, Integer> inner_map : map.values()) {
41            long total = 0;
42            
43            for (int count : inner_map.values()) {
44                total += count;
45            }
46            
47            for (int count : inner_map.values()) {
48                total -= count;
49                result += (long) count * total;
50            }
51        }
52        
53        return (int) result;
54    }
55    
56    private int gcd(int a, int b) {
57        while (b != 0) {
58            int temp = a % b;
59            a = b;
60            b = temp;
61        }
62        return Math.abs(a);
63    }
64}