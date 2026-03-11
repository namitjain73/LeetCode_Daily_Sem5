// Last updated: 3/11/2026, 11:42:55 AM
1class Solution {
2    public int bitwiseComplement(int n) {
3        // Integer.highestOb=neBit() give the highest one's bit number
4        // like in 10 the bit is --> 1010
5        // so 1000 is the highest but thst is 8
6        // so 8 << 1 -- > 16
7        // 16-1 --> 15
8        if(n==0)return 1;
9        int ans = (Integer.highestOneBit(n) << 1) - 1;
10        return (n ^ ans);
11    }
12}