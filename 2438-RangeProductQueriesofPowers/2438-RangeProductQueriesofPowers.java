// Last updated: 8/11/2025, 11:31:41 PM
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] arr = new int[queries.length];
        int mod = 1_000_000_007;
        List<Integer> list = new ArrayList<>();
        String s = Integer.toBinaryString(n);
        for(int i = 0 ; i < s.length(); i++){
            int x = n & (1 << i);
            if(x != 0) list.add(x);
        }

        for(int i = 0 ; i<queries.length ; i++){
            long p = 1;
            for(int j = queries[i][0] ; j <= queries[i][1] ; j++){
                p = (p * (list.get(j)) %mod ) %mod;
            }
            arr[i] = (int)p;
        }
        return arr;
        
    }
}