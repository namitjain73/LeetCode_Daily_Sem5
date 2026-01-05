// Last updated: 1/5/2026, 12:15:24 PM
1class Solution {
2    public int minimumBuckets(String s) {
3        int res = 0;
4        int n = s.length();
5        char[] ch= s.toCharArray();
6        for(int i = 0 ; i < n ; i++){
7            if(ch[i] == 'H'){
8                if((i+1 < n && ch[i+1] == 'B') || (i-1 >= 0 && ch[i-1] == 'B')) continue;
9                else if(i+1 < n && ch[i+1] == '.'){
10                    ch[i+1] = 'B';
11                    res++;
12                }else if(i-1 >= 0 && ch[i-1] == '.'){
13                    ch[i-1] = 'B';
14                    res++;
15                }else return -1;
16           }
17        }
18
19        return res;
20    }
21}