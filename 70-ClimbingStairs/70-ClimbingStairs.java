// Last updated: 5/19/2026, 2:46:23 PM
1class Solution {
2    public int climbStairs(int n) {
3        Map<Integer , Integer> map = new HashMap<>();
4
5        return solver(n , map);
6    }
7    public int solver(int n , Map<Integer,Integer>  map){
8        if(n == 0 || n == 1){
9            return 1;
10        }
11        
12        if(map.containsKey(n)) return map.get(n);
13
14        int skip = solver(n- 1 , map);
15        int take = solver(n-2, map);
16        map.put(n , skip+take);
17        return skip+take;
18    }
19}