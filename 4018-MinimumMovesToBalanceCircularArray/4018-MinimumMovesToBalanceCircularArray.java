// Last updated: 7/9/2026, 4:58:51 PM
class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int neg = -1;
        for(int i=0 ; i < n ; i++){
            if(balance[i] < 0){
                neg = i;
                break;
            }
        }

        if(neg == -1) return 0;
        long need = -balance[neg];
        long pos = 0;
        List<long[]> ll = new ArrayList<>();
        for(int i = 0 ;i < n ; i++){
            if(i != neg && balance[i] > 0){
                long dist = Math.min(Math.abs(i - neg), n - Math.abs(i - neg));
                ll.add(new long[]{dist, balance[i]});
                pos += balance[i];
            }
        }


        if(pos < need) return -1;

        ll.sort(Comparator.comparingLong(a -> a[0]));

        long mov = 0;
        for(long[] d : ll){
            if(need == 0) break;

            long take = Math.min(d[1] , need);
            mov += take*d[0];
            need -= take;
        }
        return mov;
    }
}