// Last updated: 7/9/2026, 5:03:28 PM
class Solution {
    private static int MOD = 1_000_000_007;

    public int countKReducibleNumbers(String s, int k) {
        if (s.length() == 1) {
            return 0;
        }

        int[] countNumsWithBitsSet = new int[1];
        countNumsWithBitsSet[0] = 1;
        // 
        int boundedOnes = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] iteratedBitsSet = new int[countNumsWithBitsSet.length + 1];

            for (int j = 0; j < countNumsWithBitsSet.length; j++) {
                iteratedBitsSet[j + 1] = (countNumsWithBitsSet[j] + iteratedBitsSet[j + 1]) % MOD;
                iteratedBitsSet[j] = (countNumsWithBitsSet[j] + iteratedBitsSet[j]) % MOD;
            }
            if (c == '1') {
                iteratedBitsSet[boundedOnes] = (iteratedBitsSet[boundedOnes] + 1) % MOD;
                boundedOnes++;
            }

            countNumsWithBitsSet = iteratedBitsSet;
        }
        for (int i = 0; i < k - 1; i++) {
            countNumsWithBitsSet[0] = 0;
            for (int j = 2; j < countNumsWithBitsSet.length; j++) {
                int reducedBitsCount = Integer.bitCount(j);
                countNumsWithBitsSet[reducedBitsCount] = (countNumsWithBitsSet[reducedBitsCount]
                        + countNumsWithBitsSet[j]) % MOD;
                countNumsWithBitsSet[j] = 0;
            }
        }

        return countNumsWithBitsSet[1];
    }
}