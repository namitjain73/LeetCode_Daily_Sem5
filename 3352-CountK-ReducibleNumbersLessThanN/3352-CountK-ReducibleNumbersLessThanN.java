// Last updated: 2/11/2026, 11:03:36 PM
1class Solution {
2    private static int MOD = 1_000_000_007;
3
4    public int countKReducibleNumbers(String s, int k) {
5        if (s.length() == 1) {
6            return 0;
7        }
8
9        int[] countNumsWithBitsSet = new int[1];
10        countNumsWithBitsSet[0] = 1;
11        // 
12        int boundedOnes = 1;
13        for (int i = 1; i < s.length(); i++) {
14            char c = s.charAt(i);
15            int[] iteratedBitsSet = new int[countNumsWithBitsSet.length + 1];
16
17            for (int j = 0; j < countNumsWithBitsSet.length; j++) {
18                iteratedBitsSet[j + 1] = (countNumsWithBitsSet[j] + iteratedBitsSet[j + 1]) % MOD;
19                iteratedBitsSet[j] = (countNumsWithBitsSet[j] + iteratedBitsSet[j]) % MOD;
20            }
21            if (c == '1') {
22                iteratedBitsSet[boundedOnes] = (iteratedBitsSet[boundedOnes] + 1) % MOD;
23                boundedOnes++;
24            }
25
26            countNumsWithBitsSet = iteratedBitsSet;
27        }
28        for (int i = 0; i < k - 1; i++) {
29            countNumsWithBitsSet[0] = 0;
30            for (int j = 2; j < countNumsWithBitsSet.length; j++) {
31                int reducedBitsCount = Integer.bitCount(j);
32                countNumsWithBitsSet[reducedBitsCount] = (countNumsWithBitsSet[reducedBitsCount]
33                        + countNumsWithBitsSet[j]) % MOD;
34                countNumsWithBitsSet[j] = 0;
35            }
36        }
37
38        return countNumsWithBitsSet[1];
39    }
40}