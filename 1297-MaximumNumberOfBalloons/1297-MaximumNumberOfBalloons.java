// Last updated: 7/9/2026, 5:17:32 PM
class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        String s = "balloon";
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , 0);
        }

        for(int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            if(map.containsKey(ch)) map.put(ch , map.getOrDefault(ch,0)+1);
        }

        int min = Integer.MAX_VALUE;
        for(char key : map.keySet()){
            if(key == 'l' || key == 'o'){
                map.put(key , map.get(key)/2);
            }
            min  = Math.min(min , map.get(key));
        }
        return min;
    }
}