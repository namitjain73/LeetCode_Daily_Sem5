// Last updated: 12/23/2025, 3:20:13 PM
1class Solution {
2    public int numWays(String s) {
3        long n=s.length();
4        long one=0;
5        long mod=1_000_000_007;
6        char[] c=s.toCharArray();
7        for(int i=0;i<c.length;i++)
8        {
9            if(c[i]=='1')
10                one++;
11        }
12        if(one==0)
13        {
14            return (int)((((n-1)*(n-2))/2)%mod);
15        }
16        if(one%3!=0)
17            return 0;
18        long ones=one/3;
19        one=0;
20        long part1=0;
21        long part2=0;
22        for(int i=0;i<c.length;i++)
23        {
24            if(c[i]=='1')
25                one++;
26            if(one==ones)
27                part1++;
28            if(one==2*ones)
29                part2++;
30        }
31        
32        return (int)((part1*part2)%mod);
33    }
34}