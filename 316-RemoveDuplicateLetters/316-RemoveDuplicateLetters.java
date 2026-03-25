// Last updated: 3/25/2026, 12:31:39 PM
1class Solution {
2    public String removeDuplicateLetters(String s) {
3        int n = s.length();
4        Stack<Character> st = new Stack<>();
5        boolean[] visited = new boolean[26];
6        Map<Character , Integer> map  = new HashMap<>();
7        for(int i = 0 ; i < n ;  i++){
8            char ch= s.charAt(i);
9            map.put(ch , map.getOrDefault(ch,0)+1);
10        }
11
12
13        for(int i = 0 ; i < n ; i++){
14            char ch = s.charAt(i);
15            if(visited[ch-'a']){
16                map.put(ch , map.get(ch)-1);
17                continue;
18            }
19            while(!st.isEmpty() && st.peek() >= ch && map.get(st.peek()) > 0){
20                // st.pop();
21                visited[st.pop() - 'a'] = false;
22            }
23            // if(!visited[ch - 'a']){
24                st.push(ch);
25                map.put(ch , map.get(ch)-1);
26                visited[ch - 'a'] = true;
27            // }
28        }
29
30        StringBuilder sb = new StringBuilder();
31        while(!st.isEmpty()) sb.append(st.pop());
32        return sb.reverse().toString();
33
34
35    }
36}