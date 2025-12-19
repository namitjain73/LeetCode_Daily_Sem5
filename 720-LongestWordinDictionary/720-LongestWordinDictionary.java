// Last updated: 12/19/2025, 10:57:47 PM
1class Solution {
2    public String longestWord(String[] words) {
3        Arrays.sort(words);
4        String s="";
5        Set<String> set=new HashSet<>();
6        for(String cur:words){
7           if(cur.length()==1||set.contains(cur.substring(0,cur.length()-1))){
8               set.add(cur);
9               if(cur.length() > s.length())s=cur;
10           }        
11        }
12        return s;
13    }
14}