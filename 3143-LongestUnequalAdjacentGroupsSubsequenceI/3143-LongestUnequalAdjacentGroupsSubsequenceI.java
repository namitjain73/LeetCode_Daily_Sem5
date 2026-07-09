// Last updated: 7/9/2026, 5:06:55 PM
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ll = new ArrayList<>();
        int pre = groups[0];
        ll.add(words[0]);

        for(int i = 1 ; i < words.length ;i++){
            if(pre != groups[i]){
                pre = groups[i];
                ll.add(words[i]);
            }
        }
        return ll;
    }
}