// Last updated: 12/22/2025, 1:54:30 PM
1class Solution {
2    public String longestNiceSubstring(String s) {
3        if(s.length() < 2) return "";
4        return solver(s , 0 ,s.length());
5    }
6    public String solver(String s , int l, int r){
7        if(r - l < 2) return "";
8
9        Set<Character> set = new HashSet<>();
10        for(int i = l ; i < r ; i++){
11            set.add(s.charAt(i));
12        }
13
14        for(int i = l ; i < r ; i++){
15            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
16                String left = solver(s , l , i);
17                String right = solver(s , i+1 , r);
18                return left.length() >= right.length() ? left : right;
19            }
20        }
21        return s.substring(l,r);
22    }
23}