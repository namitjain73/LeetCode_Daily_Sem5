// Last updated: 7/9/2026, 5:18:15 PM
class Solution {
    public int bitwiseComplement(int n) {
        // Integer.highestOb=neBit() give the highest one's bit number
        // like in 10 the bit is --> 1010
        // so 1000 is the highest but thst is 8
        // so 8 << 1 -- > 16
        // 16-1 --> 15
        if(n==0)return 1;
        int ans = (Integer.highestOneBit(n) << 1) - 1;
        return (n ^ ans);
    }
}