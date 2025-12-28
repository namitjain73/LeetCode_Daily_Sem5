// Last updated: 12/28/2025, 11:11:44 PM
1class Solution {
2    public String minimizeStringValue(String s) {
3        char[] c = s.toCharArray();
4        int[] cnt = new int[26];
5        for (char x : c){
6            if (x != '?') cnt[x - 'a']++;
7        }
8
9        List<Integer> add = new ArrayList<>();
10        for (int i = 0; i < c.length; i++){
11            if (c[i] == '?') {
12                int min = 0;
13                for (int j = 1; j < 26; j++){
14                    if (cnt[j] < cnt[min]) min = j;
15                }
16                cnt[min]++;
17                add.add(min);
18            }
19        }
20
21
22        Collections.sort(add);
23        for (int i = 0, p = 0; i < c.length; i++){
24            if (c[i] == '?') c[i] = (char) (add.get(p++) + 'a');
25        }
26
27        return String.valueOf(c);
28    }
29}