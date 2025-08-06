// Last updated: 8/7/2025, 2:04:50 AM
class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] arr = new String[(int)Math.ceil(((double)s.length())/k)];
        int j = 0;
        for(int i = 0 ; i < s.length() ; i+=k){
            if(i+k <= s.length()){
                arr[j]=s.substring(i,i+k);
                j++;
            }
            else{
                String str = s.substring(i);
                while(str.length() < k){
                    str += fill;
                }
                arr[j] = str;
            }
        }
        return arr;
    }
}