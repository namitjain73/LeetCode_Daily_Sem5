// Last updated: 3/14/2026, 10:59:12 PM
1class Solution {
2    int x;
3    public String getHappyString(int n, int k) {
4        char[] ch = {'a','b','c'};
5        x = k-1;
6        return solver(ch , n , k , "");
7    }
8    public String solver(char[] ch , int n , int k , String str){
9        if(x == 0 && str.length() == n){
10            // System.out.println(str + " ans");
11            return str;
12        }
13        if(str.length() == n){
14            // System.out.println(str);
15            x--;
16            return "";
17        }
18
19        for(int i = 0 ; i < 3 ; i++){
20            if(str.length() == 0 || ch[i] != str.charAt(str.length()-1)){
21                String ans = solver(ch , n , k , str + ch[i]);
22                if(ans.length() > 0){
23                    return ans;
24                }
25            }
26        }
27        return "";
28    }
29}