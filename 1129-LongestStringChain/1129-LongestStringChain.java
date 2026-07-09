// Last updated: 7/9/2026, 5:17:53 PM
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int[] arr = new int[words.length];
        int n = words.length;
        int max = 1;

        for(int i = 0 ; i < n ; i++){
            arr[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(predecessor(words[j] ,words[i])){
                    arr[i] = Math.max(arr[i],arr[j]+1);
                    max = Math.max(max,arr[i]);
                }
            }
        }
        return max;
    }
    public boolean predecessor(String pre, String curr) {
        if (pre.length() + 1 != curr.length()) return false;

        int i = 0, j = 0;
        boolean skipped = false;

        while (i < pre.length() && j < curr.length()) {
            if (pre.charAt(i) == curr.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped) return false;
                skipped = true;
                j++;
            }
        }

        return true;
    }

}