// Last updated: 12/28/2025, 11:33:34 PM
1class Solution {
2    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
3        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
4        long sum=0;
5       int i=0,j=0;
6       int max=0;
7       while(j<chargeTimes.length){
8           pq.add(chargeTimes[j]);
9           sum=sum+runningCosts[j];
10           if(pq.peek()+pq.size()*sum<=budget){
11               max=Math.max(max,(j-i+1));
12           }
13           else{
14               while(!pq.isEmpty() && pq.peek()+pq.size()*sum>budget){
15                   pq.remove(chargeTimes[i]);
16                   sum=sum-runningCosts[i];
17                   i++;
18               }
19           }
20           j++;
21       }
22
23      return max;
24    }
25}