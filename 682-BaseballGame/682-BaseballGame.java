// Last updated: 7/9/2026, 5:20:26 PM
class Solution {
    public int calPoints(String[] s) {
        int n = 0;
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
    if (s[i].equals("C")) {
        ll.remove(ll.size() - 1);
    } else if (s[i].equals("D")) {
        ll.add(ll.get(ll.size() - 1) * 2);
    } else if (s[i].equals("+")) {
        ll.add(ll.get(ll.size() - 1) + ll.get(ll.size() - 2));
    } else {
        ll.add(Integer.parseInt(s[i]));
    }
}
        for(int i = 0 ;  i < ll.size() ; i++){
            n += ll.get(i);
        }
        return n;
        
    }
}