// Last updated: 11/22/2026, 4:28:02 PM
1class Solution {
2    public int romanToInt(String s) {
3        Map<Character,Integer> map = new HashMap<>();
4        map.put('I',1);
5        map.put('V',5);
6        map.put('X',10);
7        map.put('L',50);
8        map.put('C',100);
9        map.put('D',500);
10        map.put('M',1000);
11
12        int pre = -1;
13        long sum = 0L;
14        for(int i = s.length()-1 ; i >= 0 ; i--){
15            int v = map.get(s.charAt(i));
16            if(pre > v){
17                sum -= (long)(v);
18            }else sum += (long)(v);
19            pre = v;
20        }
21        return (int)sum;
22
23    }
24}