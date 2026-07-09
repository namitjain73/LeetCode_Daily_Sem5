// Last updated: 7/9/2026, 5:09:02 PM
class Solution {
    public int closestTarget(String[] words, String t, int s) {
        int n = words.length;
        // int i = 0;
        // int idx = -1;
        // while(i < n){
        //     if(words[i].equals(t)) {
        //         idx = i;
        //         break;
        //     }
        //     i++;
        // }
        // if(idx == -1) return -1;
        // if(s > idx) return Math.min( (s - idx) , (idx+n-s) );
        // return Math.min( (idx - s) , (s+n-idx) );
        int i = s;
        int j= s;;
        int steps = 0;
        while(steps < n){
            if(words[i].equals(t) || words[j].equals(t)) return steps;
            i = (i+1)%n;
            j = (j-1+n)%n;
            steps++;
        }
        return -1;
    }
}