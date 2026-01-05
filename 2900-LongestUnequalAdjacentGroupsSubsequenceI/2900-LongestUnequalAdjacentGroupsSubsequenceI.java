// Last updated: 1/5/2026, 11:06:39 AM
1class Solution {
2    public List<String> getLongestSubsequence(String[] words, int[] groups) {
3        List<String> ll = new ArrayList<>();
4        int pre = groups[0];
5        ll.add(words[0]);
6
7        for(int i = 1 ; i < words.length ;i++){
8            if(pre != groups[i]){
9                pre = groups[i];
10                ll.add(words[i]);
11            }
12        }
13        return ll;
14    }
15}