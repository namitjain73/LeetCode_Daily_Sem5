// Last updated: 2/13/2026, 1:15:40 AM
1class Solution {
2    public int longestBalanced(String s) {
3        int max = 0;
4        int n = s.length();
5        
6        for(int i = 0; i < n; i++){
7            int freq[] = new int[26];
8            
9            for(int j = i; j < n; j++){
10                char ch = s.charAt(j);
11                freq[ch - 'a']++;
12                
13                if(issamefreq(freq)){
14                    max = Math.max(max, j - i + 1);
15                }
16            }
17        }
18        return max;
19    }
20    
21    public static boolean issamefreq(int arr[]){
22        int value = 0;
23        
24        for(int a : arr){
25            if(a == 0) continue;
26            
27            if(value == 0) 
28                value = a;
29            else if(value != a) 
30                return false;
31        }
32        return true;
33    }
34}