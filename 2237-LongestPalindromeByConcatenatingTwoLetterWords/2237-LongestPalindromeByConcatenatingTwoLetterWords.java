// Last updated: 7/9/2026, 5:12:03 PM
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String , Integer> map = new HashMap<>();
        int count = 0;

        for(String s : words){
            String  s1 = "";
            s1 += s.charAt(1);
            s1 += s.charAt(0);


            if(map.containsKey(s1)){
                if(map.get(s1) > 0 ){
                    count += 4;
                    map.put(s1,map.get(s1)-1);
                    if(map.get(s1) == 0){
                        map.remove(s1);
                    }
                }
                else{
                    map.put(s1,map.get(s1)+1);
                }
            }
            else{
                    map.put(s,map.getOrDefault(s,0)+1);
            }

        }

        for(String s : map.keySet()){
            if(map.get(s) > 0 && s.charAt(0) == s.charAt(1)){
                count+=2;
                break;
            }
        }
        return count;
        
    }
}