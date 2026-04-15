// Last updated: 4/15/2026, 10:41:06 PM
1class Solution {
2    public int closestTarget(String[] words, String t, int s) {
3        int n = words.length;
4        // int i = 0;
5        // int idx = -1;
6        // while(i < n){
7        //     if(words[i].equals(t)) {
8        //         idx = i;
9        //         break;
10        //     }
11        //     i++;
12        // }
13        // if(idx == -1) return -1;
14        // if(s > idx) return Math.min( (s - idx) , (idx+n-s) );
15        // return Math.min( (idx - s) , (s+n-idx) );
16        int i = s;
17        int j= s;;
18        int steps = 0;
19        while(steps < n){
20            if(words[i].equals(t) || words[j].equals(t)) return steps;
21            i = (i+1)%n;
22            j = (j-1+n)%n;
23            steps++;
24        }
25        return -1;
26    }
27}