// Last updated: 9/2/2025, 1:28:00 AM
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->
            Double.compare(b.maxpr,a.maxpr)
        );
        int n = classes.length;

        for(int i = 0 ; i< n ;i++){
            double pre = (double)((double)classes[i][0]/(double)classes[i][1]);
            double curr = (double)((double)(classes[i][0]+1)/(double)(classes[i][1]+1));
            Pair p = new Pair();
            p.maxpr = curr - pre;
            p.idx = i;
            pq.add(p);

        }

        while(extraStudents-- > 0){
            Pair p = pq.poll();
            // pq.pop();
            double max = p.maxpr;
            int idx = p.idx;

            classes[idx][0]++;
            classes[idx][1]++;

            double pre = (double)((double)classes[idx][0]/(double)classes[idx][1]);
            double curr = (double)((double)(classes[idx][0]+1)/(double)(classes[idx][1]+1));
            Pair newp = new Pair();
            newp.maxpr = curr - pre;
            newp.idx = idx;
            pq.add(newp);
        }

        double ans = 0.00;
        for(int i = 0 ; i < n ; i++){
            ans += (double)((double)classes[i][0]/(double)classes[i][1]);
        }

        return ans / n;

    }
    class Pair{
        double maxpr;
        int idx;
    }
}