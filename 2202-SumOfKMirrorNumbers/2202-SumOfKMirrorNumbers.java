// Last updated: 7/9/2026, 5:12:24 PM
class Solution {
    public long kMirror(int k, int n) {
        long ans = 0L;
        int l = 1;
        while(n > 0){
            int half = (l+1)/2;
            int min = (int)Math.pow(10,half-1);
            int max = (int)Math.pow(10,half)-1;
            for(int i = min ; i <= max ; i++){
                long num = palindrom(i , l % 2 == 0);
                if(isPalindrom(baseK(num,k))){
                    ans += num;
                    n--;
                }

                if( n < 1) break;
            }
            l++;
        }
        return ans;
        
    }
    public long palindrom(int n ,boolean even){
        long num = n;
        n = even ? n : n / 10;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            num = num * 10 + rem;
        }
        return num;
    }
    public String baseK(long n , int k){
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            sb.append(n%k);
            n = n /  k;
        }
        return sb.toString();
    }
    public boolean isPalindrom(String s){
        int i= 0 ;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}