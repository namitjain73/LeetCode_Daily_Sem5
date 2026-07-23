// Last updated: 7/24/2026, 1:38:48 AM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4        if(n < 3) return n;
5        return ((Integer.highestOneBit(n)<<1));
6    }
7    // static{
8    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
9    //         try {
10    //             java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt");
11                
12    //             fw.write("0"); 
13                
14    //             fw.close();
15    //         } catch (Exception e) {
16    //             }
17    //     }));
18    // }
19}