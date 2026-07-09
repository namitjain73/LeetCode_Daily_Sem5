// Last updated: 7/9/2026, 5:12:02 PM
class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        return executeIntruction(n,startPos,s);
    }
    private static int []  executeIntruction(int n, int[] startPos, String s) {
		// TODO Auto-generated method stub
		int [] arr=new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			int count=0;
			int xidx=startPos[0];
			int yidx=startPos[1];
			for(int j=i; j<s.length(); j++) {
				char ch=s.charAt(j);
				if(ch=='R') {
					yidx++;
				}
				if(ch=='L') {
					yidx--;
				}

				if(ch=='U') {
					xidx--;
				}

				if(ch=='D') {
					xidx++;
				}
				
				if(xidx<0 || yidx<0 || xidx>=n || yidx>=n) {
					break;
				}
				else {
					count++;
				}
			}
			arr[i]=count;
		}
		return arr;
	}
}