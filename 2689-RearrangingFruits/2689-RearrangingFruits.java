// Last updated: 7/9/2026, 5:08:30 PM
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int min = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : basket1){
            map.put(i,map.getOrDefault(i,0)+1);
            min = Math.min(min,i);
        }
        for(int i : basket2){
            map.put(i,map.getOrDefault(i,0)-1);
            min = Math.min(min,i);
        }

        List<Integer> list = new ArrayList<>();

        for(int key : map.keySet()){
            int count = map.get(key);

            if(count == 0) continue;
            else if(count % 2 != 0) return -1;
            else{
                for(int i = 0 ; i < Math.abs(count)/2 ; i++){
                    list.add(key);
                }
            }
        }

        Collections.sort(list);
        long res = 0;
        for(int i = 0 ; i < list.size()/2 ;i++){
            res += Math.min(list.get(i) , min*2);
        }

        return res;
    }
}