// Last updated: 12/25/2025, 11:22:06 PM
1class Solution {
2    public int distMoney(int m, int ch) {
3        if(m<ch){
4            return -1;
5        }
6        m-=ch;
7        int c = Math.min(m/7, ch);
8        m-=7*c;
9        ch-=c;
10        if(ch==1 && m==3){
11            c--;
12        }
13        if (ch == 0 && m > 0) {
14            c--;
15        }
16        return c;
17    }
18}