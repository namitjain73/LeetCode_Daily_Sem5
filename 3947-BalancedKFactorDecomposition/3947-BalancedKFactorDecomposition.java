// Last updated: 7/9/2026, 4:59:48 PM
class Solution {
    int[] best;
    int bestdiff = Integer.MAX_VALUE;
    public int[] minDifference(int n, int k) {
        List<Integer> list = new ArrayList<>();
        find(list , n , k);
        return best;
    }
    public void find(List<Integer> curr , int n , int k){
        if(k == 1){
            curr.add(n);
            int max = Collections.max(curr);
            int min = Collections.min(curr);

            // System.out.println(min + " " + max);
            if(max - min < bestdiff ) {
                bestdiff = max - min;
                System.out.println(curr);
                best = curr.stream().mapToInt(i -> i).toArray();;
            }
            curr.remove(curr.size()-1);
            return;
        }
        for(int i = 1 ; i <= n ; i ++){
            if(n % i == 0){
                curr.add(i);
                find(curr,n/i,k-1);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}