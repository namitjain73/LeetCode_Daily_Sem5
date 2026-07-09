// Last updated: 7/9/2026, 5:19:25 PM
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {


        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<indices.length; i++){
        if (s.startsWith(sources[i],indices[i])){
            map.put(  indices[i],i);
        }
        }  
        StringBuilder sb=new StringBuilder();
        for (int i=0; i  <s.length();){
            if (!map.containsKey(i)){
                sb.append(s.charAt(i));
                i++;
            }
            else{


                sb.append(targets[map.get(i)]); 
                i+=sources[map.get(i)].length();
        }
        }
        return sb.toString();
    }
}