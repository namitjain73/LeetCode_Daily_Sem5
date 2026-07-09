// Last updated: 7/9/2026, 5:06:49 PM
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if (s1.equals(s2)&&s2.equals(s3))
            return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        int target=Math.min(l1, Math.min(l2, l3));

        int i=0;

        while (i<target) {
            char ch1 =s1.charAt(i);
            char ch2= s2.charAt(i);
            char ch3 =s3.charAt(i);
            if (ch1!=ch2 || ch2 != ch3)
                break;
            i++;
        }
        int op1=l1-i;
        int op2=l2-i;
        int op3=l3-i;
        return i ==0?-1:op1+op2+op3;

    }
}