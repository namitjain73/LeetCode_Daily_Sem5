// Last updated: 7/9/2026, 5:18:50 PM
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] frearr = new int[26];
        int[] maxarr = new int[26];

        for(String word : words2){
            Arrays.fill(frearr,0);
            for(char ch : word.toCharArray()){
                frearr[ch - 'a']++;
            }
            for(int i = 0 ; i < 26 ; i++){
                maxarr[i] = Math.max(maxarr[i] , frearr[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for(String word : words1){
            Arrays.fill(frearr,0);
            for(char ch : word.toCharArray()){
                frearr[ch - 'a']++;
            }

            boolean flag = true;
            for(int i = 0 ;i < 26 ; i++){
                if(frearr[i] < maxarr[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                list.add(word);
            }
        }
        return list;
        
    }
}