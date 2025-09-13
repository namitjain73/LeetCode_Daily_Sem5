// Last updated: 9/13/2025, 11:17:32 AM
class Solution {
    public int maxFreqSum(String s) {
        int[] fre = new int[26];
        for(char ch : s.toCharArray()){
            fre[ch - 'a']++;
        }

        int max1 = 0;
        int max2 = 0;
        for(int i =0 ;i < 26 ; i++){
            if(i==0||i==4||i==8||i==14||i==20){
                max1 = Math.max(max1,fre[i]);
            }else{
                max2= Math.max(max2,fre[i]);
           }
        }
        return max1+max2;
    }
}