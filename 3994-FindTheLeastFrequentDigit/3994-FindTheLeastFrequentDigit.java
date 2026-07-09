// Last updated: 7/9/2026, 4:59:10 PM
class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            map.put(rem , map.getOrDefault(rem,0)+1);
        }

        int ans = Integer.MAX_VALUE;
        System.out.println(map);
        for(int x : map.keySet()){
                min = Math.min(min,map.get(x));
        }
        for(int x : map.keySet()){
            if(min == map.get(x)){
                ans = Math.min(ans,x);
            }
        }
        return ans;

        
    }
}