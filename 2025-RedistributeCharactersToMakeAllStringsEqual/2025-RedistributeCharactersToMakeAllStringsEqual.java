// Last updated: 7/9/2026, 5:13:50 PM
class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character , Integer> mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
        for (int j = 0; j < words[i].length(); j++) { 
            char c = words[i].charAt(j);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
    }

        int n = words.length;
    for (int count : mp.values()) {
        if (count % n != 0) return false;
    }

    return true;

    }
}