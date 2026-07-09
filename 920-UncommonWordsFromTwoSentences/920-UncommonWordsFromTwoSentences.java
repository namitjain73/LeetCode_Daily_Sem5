// Last updated: 7/9/2026, 5:19:00 PM
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 +" " + s2;
        List<String> list2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < s.length() ;i++){
            if(s.charAt(i) == ' '){
                list.add(s.substring(j,i));
                j = i  + 1;
            }
            if(i == s.length()-1){
                list.add(s.substring(j,i+1));
            }
            
        }

        for(int i = 0; i < list.size() ; i++){
            int c = 0;
            for(j = 0 ;  j < list.size() ; j++){
                if(list.get(i).equals(list.get(j)) && i  != j){
                    c++;
                }
            }
            if(c == 0){
                list2.add(list.get(i));
            }
        }

        String[] arr = new String[list2.size()];
        for(int i = 0; i < list2.size() ; i++){
            arr[i] = list2.get(i);
        }
        return arr;
        
    }
}