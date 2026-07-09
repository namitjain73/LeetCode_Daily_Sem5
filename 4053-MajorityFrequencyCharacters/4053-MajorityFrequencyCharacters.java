// Last updated: 7/9/2026, 4:58:34 PM
class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        Map<Integer, List<Character>> groups = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            groups.computeIfAbsent(f, k -> new ArrayList<>()).add(entry.getKey());
        }

        int bsize = -1;
        int fre = -1;
        List<Character> group = new ArrayList<>();
        for (Map.Entry<Integer, List<Character>> entry : groups.entrySet()) {
            int f = entry.getKey();
            List<Character> chars = entry.getValue();
            int size = chars.size();

            if (size > bsize || (size == bsize && f > fre)) {
                bsize = size;
                fre = f;
                group = chars;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : group){
            sb.append(ch);
        }
        return sb.toString();
    }
}