// Last updated: 7/9/2026, 5:11:21 PM
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0;
        int c = 0;
        double avg = 0;
        for(int i : nums){
            sum += i;
            pq.add((double)i);
        }
        avg = sum;
        avg = avg/(double)2;
        while(avg < sum){
            double n = (pq.poll())/(double)2;
            pq.add(n);
            sum -= n;
            c++;
        }
        return c;
    }
}