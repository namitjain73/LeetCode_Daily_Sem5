// Last updated: 12/21/2025, 2:43:52 PM
1class Solution {
2    public boolean isLongPressedName(String name, String typed) {
3        int i = 0;
4        int j = 0;
5        while(j < typed.length()){
6            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
7                i++;
8                j++;
9            }
10            else if(j> 0 && typed.charAt(j) == typed.charAt(j-1)){
11                j++;
12            }
13            else return false;
14        }
15        return i == name.length();
16    }
17}