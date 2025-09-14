// Last updated: 9/15/2025, 3:30:34 AM
class Solution {
    class Pair{
        int ele;
        int freq;
        Pair(int ele , int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i,0)+1);
        }
        for(int x : map.keySet()){
            pq.add(new Pair(x , map.get(x)));
        }


        int[] arr = new int[k];
        int i = 0;
        while(k-- > 0){
            arr[i++] = pq.poll().ele;
        }
        return arr;

    }
}