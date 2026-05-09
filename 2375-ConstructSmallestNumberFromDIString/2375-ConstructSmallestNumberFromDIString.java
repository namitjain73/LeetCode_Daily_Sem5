// Last updated: 5/9/2026, 12:55:38 PM
1class Solution {
2    public String smallestNumber(String pattern) {
3        int n = pattern.length();
4        int[] arr = new int[n+1];
5        Stack<Integer> st = new Stack<>();
6        int c = 1;
7
8        for(int i = 0 ; i <= n ; i++){
9            if(i == n || pattern.charAt(i) == 'I'){
10                arr[i] = c;
11                c++;
12                while(!st.isEmpty()){
13                    arr[st.pop()] =  c;
14                    c++;
15                }
16            }else if(pattern.charAt(i) == 'D') st.push(i);
17        }
18        StringBuilder sb = new StringBuilder();
19        for(int i = 0 ; i <= n ; i++) sb.append(arr[i]);
20        return sb.toString();
21    }
22}