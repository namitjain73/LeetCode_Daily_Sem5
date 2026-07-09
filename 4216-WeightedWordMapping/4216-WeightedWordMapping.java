// Last updated: 7/9/2026, 4:57:51 PM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=  new StringBuilder();
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++){
            map.put((char)(i+'a'), weights[i]);
        }
        for(int i = 0 ; i < words.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < words[i].length() ; j++){
                sum += map.get(words[i].charAt(j));
            }
            System.out.println(sum);
            sb.append((char)('a'+26-1-sum%26));
        }
        return sb.toString();
    }
}