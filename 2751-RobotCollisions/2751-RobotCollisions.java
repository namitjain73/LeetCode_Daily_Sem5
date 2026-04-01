// Last updated: 4/2/2026, 2:01:32 AM
1class Solution {
2    class Robot {
3        int pos;
4        char dir;
5        int health;
6        int orig_i;
7
8        Robot(int pos, char dir, int health, int orig_i) {
9            this.pos = pos;
10            this.dir = dir;
11            this.health = health;
12            this.orig_i = orig_i;
13        }
14    }
15
16    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
17        int n = positions.length;
18        Robot[] robots = new Robot[n];
19
20        for (int i = 0; i < n; i++) {
21            robots[i] = new Robot(
22                positions[i],
23                directions.charAt(i),
24                healths[i],
25                i
26            );
27        }
28
29        Arrays.sort(robots, (a, b) -> Integer.compare(a.pos, b.pos));
30
31        Stack<Robot> stack = new Stack<>();
32        for (Robot curr : robots) {
33            while (!stack.isEmpty() && curr.dir == 'L' && stack.peek().dir == 'R') {
34                Robot top = stack.peek();
35
36                if (top.health > curr.health) {
37                    top.health -= 1;
38                    curr.health = 0;
39                    break;
40                } else if (top.health < curr.health) {
41                    stack.pop();
42                    curr.health -= 1;
43                } else {
44                    stack.pop();
45                    curr.health = 0;
46                    break;
47                }
48            }
49
50            if (curr.health > 0) {
51                stack.push(curr);
52            }
53        }
54
55        stack.sort((a, b) -> Integer.compare(a.orig_i, b.orig_i));
56
57        List<Integer> res = new ArrayList<>();
58        for (Robot r : stack) {
59            res.add(r.health);
60        }
61
62        return res;
63    }
64}