// Last updated: 7/20/2026, 12:55:54 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] lastidx = new int[26];
4        boolean[] arr = new boolean[26];
5        Stack<Character> st = new Stack<>();
6
7        for(int i = 0 ; i < s.length() ; i++){
8            lastidx[s.charAt(i) - 'a'] = i;
9        }
10
11        for(int i = 0 ; i < s.length() ; i++){
12            char ch = s.charAt(i);
13            int idx = ch - 'a';
14
15            if(arr[idx]) continue;
16
17            while(!st.empty() && ch < st.peek() && i < lastidx[st.peek() - 'a']){
18                arr[st.pop() - 'a'] = false;
19            }
20            arr[idx] = true;
21            st.push(ch);
22        }
23
24        StringBuilder sb = new StringBuilder();
25        while(!st.empty()){
26            sb.append(st.pop());
27        }
28
29        return sb.reverse().toString();
30
31
32    }
33}