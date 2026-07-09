// Last updated: 7/9/2026, 5:23:34 PM
class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
	    int c = 0;
	    for(char ch : s.toCharArray()){
	        if(ch == '1') c++;
	    }
        return c;
    }
}