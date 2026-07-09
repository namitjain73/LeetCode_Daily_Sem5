// Last updated: 7/9/2026, 5:25:59 PM
class Solution {
    		static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        } 
        return Print(digits,"",list);

    }
    

    public static List<String> Print(String ques,String ans,List<String> list){
        if(ques.length() == 0){
            list.add(ans);
            return list;
        }
        char ch = ques.charAt(0);
        String setstring = key[ch - '0'];
        for(int i = 0 ; i < setstring.length() ; i++){
            Print(ques.substring(1),ans+setstring.charAt(i),list);
        }
        return list;
    }
}