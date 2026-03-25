// Last updated: 3/26/2026, 2:01:04 AM
1class Solution {
2    public String decodeString(String s) {
3        Stack<String> st = new Stack<>();
4
5        for(int i = 0 ; i < s.length() ; i++){
6            char ch = s.charAt(i);
7            if(ch != ']'){
8                st.push(""+ch);
9            }else{
10                String c = "";
11                String str = "";
12                while(!st.isEmpty() && !st.peek().equals("[")){
13                    str = st.pop() + str;
14                }
15                st.pop();
16                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
17                    c = st.pop() + c;
18                }
19                
20                int x = Integer.parseInt(c);
21                st.push(str.repeat(x));
22            }
23        }
24
25        System.out.println(st);
26        StringBuilder sb = new StringBuilder();
27        String stt= "";
28        while(!st.isEmpty()) stt = st.pop() + stt;
29        return stt;
30    }
31}