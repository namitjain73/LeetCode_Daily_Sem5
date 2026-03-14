// Last updated: 3/14/2026, 11:08:05 PM
1class Solution {
2    public List<Boolean> camelMatch(String[] queries, String pattern) {
3        List<Boolean> ll = new ArrayList<>();
4        for(String s : queries){
5            ll.add(valid(s , pattern));
6        }
7        return ll;
8    }
9    public boolean valid(String str , String p){
10        int l = 0; //str
11        int r = 0; //p
12        while(l < str.length()){
13            if(r < p.length() && str.charAt(l) == p.charAt(r)){
14                r++;
15            }else if(Character.isUpperCase(str.charAt(l))) return false;
16            l++;
17        }
18
19        return r == p.length();
20    }
21}