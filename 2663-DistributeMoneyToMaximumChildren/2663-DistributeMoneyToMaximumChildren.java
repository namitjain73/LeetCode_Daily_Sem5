// Last updated: 7/9/2026, 5:08:38 PM
class Solution {
    public int distMoney(int m, int ch) {
        if(m<ch){
            return -1;
        }
        m-=ch;
        int c = Math.min(m/7, ch);
        m-=7*c;
        ch-=c;
        if(ch==1 && m==3){
            c--;
        }
        if (ch == 0 && m > 0) {
            c--;
        }
        return c;
    }
}