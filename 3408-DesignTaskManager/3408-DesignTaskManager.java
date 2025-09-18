// Last updated: 9/19/2025, 1:25:28 AM
class TaskManager {
    class Task {
        int user, taskId, priority;
        Task(int u, int t, int p) {
            user = u; taskId = t; priority = p;
        }
    }

    // taskId -> (user, latest priority)
    Map<Integer, Integer> taskToUser = new HashMap<>();
    Map<Integer, Integer> taskToPriority = new HashMap<>();

    // max-heap by priority, then taskId descending
    PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
        if (a.priority == b.priority) return b.taskId - a.taskId;
        return b.priority - a.priority;
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) {
            taskToUser.put(t.get(1), t.get(0));
            taskToPriority.put(t.get(1), t.get(2));
            pq.add(new Task(t.get(0), t.get(1), t.get(2)));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId, userId);
        taskToPriority.put(taskId, priority);
        pq.add(new Task(userId, taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        int userId = taskToUser.get(taskId);
        taskToPriority.put(taskId, newPriority);
        pq.add(new Task(userId, taskId, newPriority)); 
    }

    public void rmv(int taskId) {
        taskToUser.remove(taskId);
        taskToPriority.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.peek();
            if(taskToPriority.containsKey(top.taskId) && 
                taskToUser.containsKey(top.taskId) &&
                top.priority == taskToPriority.get(top.taskId) &&
                top.user == taskToUser.get(top.taskId)) {
                taskToPriority.remove(top.taskId);
                taskToUser.remove(top.taskId);
                return pq.poll().user;
            }
            pq.poll();
        }
        return -1;
    }
}
