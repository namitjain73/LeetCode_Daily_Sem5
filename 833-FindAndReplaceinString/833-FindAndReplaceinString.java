// Last updated: 12/22/2025, 5:16:02 PM
1class Solution {
2    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
3
4
5        Map<Integer,Integer> map=new HashMap<>();
6        for(int i=0; i<indices.length; i++){
7        if (s.startsWith(sources[i],indices[i])){
8            map.put(  indices[i],i);
9        }
10        }  
11        StringBuilder sb=new StringBuilder();
12        for (int i=0; i  <s.length();){
13            if (!map.containsKey(i)){
14                sb.append(s.charAt(i));
15                i++;
16            }
17            else{
18
19
20                sb.append(targets[map.get(i)]); 
21                i+=sources[map.get(i)].length();
22        }
23        }
24        return sb.toString();
25    }
26}