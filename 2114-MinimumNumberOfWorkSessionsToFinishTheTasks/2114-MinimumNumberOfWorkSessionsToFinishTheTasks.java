// Last updated: 7/9/2026, 5:13:07 PM
class Solution {
    int mins;
    public int minSessions(int[] tasks, int time) {
        Arrays.sort(tasks);
        mins = tasks.length;
        int[] works = new int[mins];
        backtrack(tasks.length - 1, tasks, works, time, 0);
        return mins;
    }

    private void backtrack(int index, int[] tasks, int[] works, int time, int used) {
        if (index < 0) {
            mins = Math.min(mins, used);
            return;
        }
        if (used >= mins) return;
        int task = tasks[index];
        for (int i = 0; i < used; i++) {
            if (works[i] + task <= time) {
                works[i] += task;
                backtrack(index - 1, tasks, works, time, used);
                works[i] -= task;
            }
        }
        works[used] = task;
        backtrack(index - 1, tasks, works, time, used + 1);
        works[used] = 0;
    }
}