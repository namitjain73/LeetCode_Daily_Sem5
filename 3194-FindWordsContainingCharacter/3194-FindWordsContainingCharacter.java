// Last updated: 7/9/2026, 5:06:51 PM
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0  ; i < words.length ; i++){
            if(words[i].contains(Character.toString(x))){
                list.add(i);
            }
        }
        return list;
        
    }
}