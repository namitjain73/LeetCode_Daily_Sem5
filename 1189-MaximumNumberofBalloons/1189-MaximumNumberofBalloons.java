// Last updated: 6/23/2026, 7:03:09 PM
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        Map<Character,Integer> map = new HashMap<>();
4        String s = "balloon";
5        for(int i = 0 ; i < s.length() ; i++){
6            map.put(s.charAt(i) , 0);
7        }
8
9        for(int i = 0 ; i < text.length() ; i++){
10            char ch = text.charAt(i);
11            if(map.containsKey(ch)) map.put(ch , map.getOrDefault(ch,0)+1);
12        }
13
14        int min = Integer.MAX_VALUE;
15        for(char key : map.keySet()){
16            if(key == 'l' || key == 'o'){
17                map.put(key , map.get(key)/2);
18            }
19            min  = Math.min(min , map.get(key));
20        }
21        return min;
22    }
23}