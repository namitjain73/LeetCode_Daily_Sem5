// Last updated: 7/9/2026, 5:24:06 PM
class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ll = new ArrayList<>();

        solver(s,list, ll);
        return ll;
    }
    public void solver(String s , List<String> list , List<List<String>> ll){
        if(s.length() == 0){
            // System.out.println(list);
            ll.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 1 ; i <= s.length() ; i++){

            String str1 = s.substring(0,i);
            String str2 = s.substring(i);
            // System.out.println(str1 + "  "  + str2);
            if(palindrom(str1)){
                list.add(str1);
                solver(str2 , list , ll);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean palindrom(String s){
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}