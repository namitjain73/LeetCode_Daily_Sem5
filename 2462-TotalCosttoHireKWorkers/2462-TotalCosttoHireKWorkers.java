// Last updated: 8/27/2025, 1:01:26 AM
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        // List<Integer> ll = new ArrayList<>();
        // for(int x : costs) ll.add(x);
        boolean[] arr = new boolean[costs.length];
        PriorityQueue<int[]> front = new PriorityQueue<>((a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0] );
        PriorityQueue<int[]>   end = new PriorityQueue<>((a,b) ->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        long res = 0;
        int i = 0;
        int j = costs.length-1;
        while(i <= j && front.size() < candidates){
            front.add(new int[]{costs[i],i});
            i++;
        }
        while(i <= j && end.size() < candidates){
            end.add(new int[]{costs[j],j});
            j--;
        }

        while(k-- > 0){
            if(end.isEmpty() || (!front.isEmpty() && front.peek()[0] <= end.peek()[0])){
                res += front.poll()[0];
                if(i <= j){
                    front.add(new int[]{costs[i],i});
                    i++;
                }
            }else{
                res += end.poll()[0];
                if(i <= j){
                    end.add(new int[]{costs[j],j});
                    j--;
                }
            }
        }
        return res;        
    }
}