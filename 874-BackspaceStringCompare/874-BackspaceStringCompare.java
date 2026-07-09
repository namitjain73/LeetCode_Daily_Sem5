// Last updated: 7/9/2026, 5:19:20 PM
class Solution {
    public boolean backspaceCompare(String s, String t) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for(int i = 0 ; i< s.length() ; i++){
            if(list1.size() != 0 && s.charAt(i) == '#'){
                list1.remove(list1.size()-1);
            }
            else if(s.charAt(i) != '#'){
                list1.add(s.charAt(i));
            }
        }
        for(int i= 0 ;i  < t.length() ; i++){
            if(list2.size() != 0 && t.charAt(i) == '#'){
                list2.remove(list2.size()-1);
            }
            else if(t.charAt(i) != '#'){
                list2.add(t.charAt(i));
            }
        }

        if(list1.size() != list2.size()) return false;
        for(int i = 0 ; i < list1.size() ; i++){
            if(list1.get(i) !=  list2.get(i)) return false;
        }
        return true;

        
    }
}