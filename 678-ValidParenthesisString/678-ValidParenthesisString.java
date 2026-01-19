// Last updated: 1/19/2026, 11:48:08 AM
1class Solution {
2    public boolean checkValidString(String s) {
3        int n = s.length();
4        int min= 0;
5        int max = 0;
6        for(int i = 0 ; i <  n ; i++){
7            if(s.charAt(i) == '('){
8                min++;
9                max++;
10            }else if(s.charAt(i) == ')'){
11                min--;
12                max--;
13            }else{
14                min--; // );
15                max++; //(
16            }
17
18            if(max < 0) return false;
19            if(min < 0) min = 0;// * treted as empty string
20        }
21        return min == 0;
22    }
23}