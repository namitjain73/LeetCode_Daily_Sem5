// Last updated: 11/19/2026, 3:24:08 PM
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        Map<String, List<String>> map = new HashMap<>();
4
5        for(int i = 0 ;i < strs.length ; i++){
6            String key = sort(strs[i]);
7            if(!map.containsKey(key)) map.put(key , new ArrayList<>());
8            map.get(key).add(strs[i]);
9        }
10        return new ArrayList<>(map.values());
11    }
12    public String sort(String s){
13        char[] ch = s.toCharArray();
14        Arrays.sort(ch);
15        return new String(ch);
16    }
17}