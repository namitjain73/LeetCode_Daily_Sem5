// Last updated: 7/9/2026, 4:59:46 PM
class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int[] arr = arrivals;
        int dis = 0;
        Map<Integer,List<Integer>> ki = new HashMap<>();
        Map<Integer,Integer> si = new HashMap<>();
        for(int i= 0 ; i < arrivals.length ; i++){
            int d = i+1;
            int it = arrivals[i];
            ki.putIfAbsent(it,new ArrayList<>());
            si.putIfAbsent(it,0);
            List<Integer> dk = ki.get(it);
            int s = si.get(it);
            int ws = Math.max(1 ,d-w+1);
                while(s  < dk.size() && dk.get(s) < ws){
                    s++;
                }

            si.put(it,s);
            int c= dk.size() - s;
            if(c   < m){
                dk.add(d);
            }else{
                dis++;
            }
        }
        return dis;
    }
}