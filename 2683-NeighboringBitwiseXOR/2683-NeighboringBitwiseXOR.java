// Last updated: 1/21/2026, 12:09:06 PM
1class Solution {
2    public int getXORSum(int[] arr1, int[] arr2) {
3        int xor1 = 0;
4        int xor2 = 0;
5        for(int i= 0 ; i < arr1.length ; i++) xor1 ^= arr1[i];
6        for(int j= 0 ; j < arr2.length;  j++) xor2 ^= arr2[j];
7        return xor1 & xor2;
8    }
9}