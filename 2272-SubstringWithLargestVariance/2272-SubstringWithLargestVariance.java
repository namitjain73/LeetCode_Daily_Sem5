// Last updated: 1/21/2026, 11:48:10 PM
1class Solution {
2    public int largestVariance(String s) {
3        
4        int [] freq = new int[26];
5        for(int i = 0 ; i < s.length() ; i++)
6            freq[(int)(s.charAt(i) - 'a')]++;
7        
8        int maxVariance = 0;
9        for(int a = 0 ; a < 26 ; a++){
10            for(int b = 0 ; b < 26 ; b++){
11                int remainingA = freq[a];
12                int remainingB = freq[b];
13                if(a == b || remainingA == 0 || remainingB == 0) continue;
14                int currBFreq = 0, currAFreq = 0;
15                for(int i = 0 ; i < s.length() ; i++){
16                    int c =  (int)(s.charAt(i) - 'a');
17                    
18                    if(c == b) currBFreq++;
19                    if(c == a) {
20                        currAFreq++;
21                        remainingA--;
22                    }
23                    
24                    if(currAFreq > 0)
25                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
26                    
27                    if(currBFreq < currAFreq &&  remainingA >= 1){
28                        currBFreq = 0;
29                        currAFreq = 0;
30                    }
31                }
32            }
33        }
34        
35        return maxVariance;
36    }
37}