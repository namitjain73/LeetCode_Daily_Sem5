// Last updated: 7/9/2026, 5:21:13 PM
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1] , a[1]));
        int n = profits.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n;  i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr , (a,b)->a[0]-b[0]);

        for(int i = 0 ; i <n ;){
            while(i < n && arr[i][0] <= w){
                pq.add(new int[] {arr[i][0] , arr[i][1]});
                i++;
            }

            if(k == 0 || pq.isEmpty()) return w;
            k--;
            w += pq.poll()[1];
        }

        while(!pq.isEmpty() && k > 0){
            w += pq.poll()[1];
            k--;
        }
        return w;
    }
}