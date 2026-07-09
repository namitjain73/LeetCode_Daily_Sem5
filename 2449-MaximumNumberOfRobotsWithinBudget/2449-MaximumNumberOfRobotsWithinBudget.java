// Last updated: 7/9/2026, 5:10:06 PM
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long sum=0;
       int i=0,j=0;
       int max=0;
       while(j<chargeTimes.length){
           pq.add(chargeTimes[j]);
           sum=sum+runningCosts[j];
           if(pq.peek()+pq.size()*sum<=budget){
               max=Math.max(max,(j-i+1));
           }
           else{
               while(!pq.isEmpty() && pq.peek()+pq.size()*sum>budget){
                   pq.remove(chargeTimes[i]);
                   sum=sum-runningCosts[i];
                   i++;
               }
           }
           j++;
       }

      return max;
    }
}