// Last updated: 1/13/2026, 11:18:46 PM
1class Solution {
2    int mins;
3    public int minSessions(int[] tasks, int time) {
4        Arrays.sort(tasks);
5        mins = tasks.length;
6        int[] works = new int[mins];
7        backtrack(tasks.length - 1, tasks, works, time, 0);
8        return mins;
9    }
10
11    private void backtrack(int index, int[] tasks, int[] works, int time, int used) {
12        if (index < 0) {
13            mins = Math.min(mins, used);
14            return;
15        }
16        if (used >= mins) return;
17        int task = tasks[index];
18        for (int i = 0; i < used; i++) {
19            if (works[i] + task <= time) {
20                works[i] += task;
21                backtrack(index - 1, tasks, works, time, used);
22                works[i] -= task;
23            }
24        }
25        works[used] = task;
26        backtrack(index - 1, tasks, works, time, used + 1);
27        works[used] = 0;
28    }
29}