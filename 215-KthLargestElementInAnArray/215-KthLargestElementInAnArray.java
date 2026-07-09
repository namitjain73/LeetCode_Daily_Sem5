// Last updated: 7/9/2026, 5:23:15 PM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}