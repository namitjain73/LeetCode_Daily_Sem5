// Last updated: 12/24/2025, 12:15:20 PM
1class Solution {
2    public int findMinimumOperations(String s1, String s2, String s3) {
3        if (s1.equals(s2)&&s2.equals(s3))
4            return 0;
5        int l1 = s1.length();
6        int l2 = s2.length();
7        int l3 = s3.length();
8
9        int target=Math.min(l1, Math.min(l2, l3));
10
11        int i=0;
12
13        while (i<target) {
14            char ch1 =s1.charAt(i);
15            char ch2= s2.charAt(i);
16            char ch3 =s3.charAt(i);
17            if (ch1!=ch2 || ch2 != ch3)
18                break;
19            i++;
20        }
21        int op1=l1-i;
22        int op2=l2-i;
23        int op3=l3-i;
24        return i ==0?-1:op1+op2+op3;
25
26    }
27}