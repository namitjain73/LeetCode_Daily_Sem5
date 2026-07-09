// Last updated: 7/9/2026, 5:25:23 PM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)) map.put(key , new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}