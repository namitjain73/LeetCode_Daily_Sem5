// Last updated: 7/9/2026, 5:19:54 PM
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        for(int i = 0 ; i < s.length() ; i++){
            end = Math.max(end, arr[s.charAt(i)-'a'] );
            if(i == end){
                res.add(end - start + 1);
                start = i+1;
            }
        }
        return res;
        
    }
}