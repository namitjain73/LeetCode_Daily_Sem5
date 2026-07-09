// Last updated: 7/9/2026, 5:12:30 PM
class Solution {
    public int minimumBuckets(String s) {
        int res = 0;
        int n = s.length();
        char[] ch= s.toCharArray();
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == 'H'){
                if((i+1 < n && ch[i+1] == 'B') || (i-1 >= 0 && ch[i-1] == 'B')) continue;
                else if(i+1 < n && ch[i+1] == '.'){
                    ch[i+1] = 'B';
                    res++;
                }else if(i-1 >= 0 && ch[i-1] == '.'){
                    ch[i-1] = 'B';
                    res++;
                }else return -1;
           }
        }

        return res;
    }
}