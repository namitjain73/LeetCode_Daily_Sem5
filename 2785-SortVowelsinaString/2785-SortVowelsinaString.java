// Last updated: 9/12/2025, 3:08:53 AM
import java.util.*;

class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> aL = new ArrayList<>();
        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel[arr[i]]) {
                aL.add(arr[i]);
            }
        }
        Collections.sort(aL);
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel[arr[i]]) {
                arr[i] = aL.get(j);
                j++;
            }
        }
        return new String(arr);
    }
}