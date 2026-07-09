// Last updated: 7/9/2026, 5:20:23 PM
class Solution {
    class Pair{
        String ele;
        int freq;
        Pair(String ele , int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.freq == b.freq) return a.ele.compareTo(b.ele);
            return b.freq-a.freq;
        });
        Map<String,Integer> map = new HashMap<>();
        for(String i : words){
            map.put(i , map.getOrDefault(i,0)+1);
        }
        for(String x : map.keySet()){
            pq.add(new Pair(x , map.get(x)));
        }


        List<String> ll = new ArrayList<>();
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a,b)->{
            if(b.freq == b.freq) return a.ele.compareTo(b.ele);
            return b.freq-a.freq;
        });
        int i = 0;
        while(k-- > 0){
            Pair p = pq.poll();
            if(!pq.isEmpty() && p.freq == pq.peek().freq){
                if(p.ele.compareTo(pq.peek().ele) < 0){
                    ll.add(p.ele);
                }else{
                    ll.add(pq.poll().ele);
                    pq.add(p);
                }
            }
            else ll.add(p.ele);
        }
        return ll;

    }
}