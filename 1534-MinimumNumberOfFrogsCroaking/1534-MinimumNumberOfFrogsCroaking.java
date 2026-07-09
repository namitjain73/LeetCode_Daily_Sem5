// Last updated: 7/9/2026, 5:16:25 PM
class Solution {
    public int minNumberOfFrogs(String s) {
        int ans = 0;
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int frogcount = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case 'c':
                    c++;
                    frogcount++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    frogcount--;
                    break;
            }
            ans = Math.max(ans,frogcount);
            if(c<r || r<o || o<a || a<k) return -1;
        }

        return frogcount == 0 ? ans : -1;
        
    }
}