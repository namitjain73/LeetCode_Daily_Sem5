// Last updated: 7/9/2026, 5:09:25 PM
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> result = new ArrayList<String>();
        for (String words : queries) {

            if (matchingWord(words, dictionary)) {
                result.add(words);
            }
        }
        return result;
    }

    private boolean matchingWord(String words, String[] dictionary) {

        for (String dicWord : dictionary) {
            if (words.equals(dicWord)) {
                return true;
            }
            int count = 0;

            for (int i = 0; i < words.length(); i++) {

                if (dicWord.charAt(i) != words.charAt(i)) {

                    count++;
                }
                

            }

            if (count <= 2) {
                return true;
            }
        }
        return false;
    }
}