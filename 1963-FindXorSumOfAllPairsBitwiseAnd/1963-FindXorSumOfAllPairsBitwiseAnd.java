// Last updated: 7/9/2026, 5:14:14 PM
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0;
        int xor2 = 0;
        for(int i= 0 ; i < arr1.length ; i++) xor1 ^= arr1[i];
        for(int j= 0 ; j < arr2.length;  j++) xor2 ^= arr2[j];
        return xor1 & xor2;
    }
}