// Last updated: 3/25/2026, 2:13:44 AM
1class Solution {
2    public boolean wordPattern(String t, String s) {
3        boolean f = true;
4        String[] str = s.split(" ");
5        if(str.length != t.length()) return false;
6        Map<Character,String> map = new HashMap<>();
7        Map<String,Character> map1 = new HashMap<>();
8        for(int i = 0 ; i < str.length ; i++){
9            if(!map.containsKey(t.charAt(i))){
10                map.put(t.charAt(i) , str[i]);
11            }else{
12                if(!map.get(t.charAt(i)).equals(str[i])){
13                    return false;
14                }
15            }
16
17            if(!map1.containsKey(str[i])){
18                map1.put(str[i] , t.charAt(i));
19            }else{
20                if(!map1.get(str[i]).equals(t.charAt(i))){
21                    return false;
22                }
23            }
24        }
25        return true;
26    }
27}