// Last updated: 7/9/2026, 5:17:56 PM
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < stones.length ; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int y = pq.remove();
            int x = pq.remove();
            // if()
            if(x < y){
                pq.add(y - x);
            }

        }
        return (pq.isEmpty() ? 0 : pq.remove());

                
    }
}