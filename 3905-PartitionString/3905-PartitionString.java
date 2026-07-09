// Last updated: 7/9/2026, 5:00:17 PM
class Solution {
    public List<String> partitionString(String s) {
        Set<String> set= new HashSet<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ;i++){
            sb.append(s.charAt(i));
            if(!set.contains(sb.toString())){
                list.add(sb.toString());
                set.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return list;
    }
}