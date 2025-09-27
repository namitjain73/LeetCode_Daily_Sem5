// Last updated: 9/28/2025, 1:39:40 AM
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            return map.get(b)-map.get(a);
        });

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0)+1);
        }

        for(char ch : map.keySet()){
            pq.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int n = map.get(ch);
            while(n-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}