// Last updated: 7/9/2026, 5:05:38 PM
class Solution {
    public String minimizeStringValue(String s) {
        char[] c = s.toCharArray();
        int[] cnt = new int[26];
        for (char x : c){
            if (x != '?') cnt[x - 'a']++;
        }

        List<Integer> add = new ArrayList<>();
        for (int i = 0; i < c.length; i++){
            if (c[i] == '?') {
                int min = 0;
                for (int j = 1; j < 26; j++){
                    if (cnt[j] < cnt[min]) min = j;
                }
                cnt[min]++;
                add.add(min);
            }
        }


        Collections.sort(add);
        for (int i = 0, p = 0; i < c.length; i++){
            if (c[i] == '?') c[i] = (char) (add.get(p++) + 'a');
        }

        return String.valueOf(c);
    }
}