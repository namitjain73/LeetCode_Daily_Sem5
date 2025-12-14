// Last updated: 12/14/2025, 8:25:31 AM
1class Solution {
2    public String reverseWords(String s) {
3        String[] arr = s.split(" ");
4        int v = vowel_count(arr[0]);
5
6        StringBuilder sb = new StringBuilder();
7        sb.append(arr[0]);
8        for(int i = 1 ; i < arr.length ; i++){
9            sb.append(" ");
10            if(vowel_count(arr[i]) == v){
11                sb.append(reverse(arr[i]));
12            }else{
13                sb.append(arr[i]);
14            }
15        }
16        return sb.toString();
17    }
18    public String reverse(String s){
19        StringBuilder sb = new StringBuilder(s);
20        return sb.reverse().toString();
21    }
22
23    public int vowel_count(String s){
24        int v = 0;
25        for(int i = 0 ; i < s.length() ; i++){
26            char ch = s.charAt(i);
27            if(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch== 'u') v++;
28        }
29        return v;
30    }
31}