// Last updated: 7/9/2026, 5:14:21 PM
class Solution {
    public int findTheWinner(int n, int k) {
        // create a queue to perform circular table operations
        Queue<Integer> q = new LinkedList<>();
        // add all item in thw queue
        for(int i= 1 ; i <= n ; i++) q.add(i);
        int i = 1;
        // itrate all the people 
        while(q.size() > 1){
            // remove kth person and update the kth value
            if(i == k) {
                q.poll();
                i = 1;
                continue;
            }
            // remove first and add last because it is not turn which is remove from the queue 
            q.add(q.poll());
            i++;
        }
        // return the remaning person which has win the game
        return q.poll();
    }
}