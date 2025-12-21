// Last updated: 12/21/2025, 3:44:56 PM
1class Solution {
2    public String makeLargestSpecial(String s) {
3        // 1. Identify independent "Special Substrings" at the current level
4        List<String> results = new ArrayList<>();
5        int count = 0; 
6        int start = 0;
7        
8        for (int end = 0; end < s.length(); end++) {
9            // Treat '1' as ( and '0' as )
10            count += (s.charAt(end) == '1') ? 1 : -1;
11            
12            // 2. When count == 0, we found a complete, independent special substring
13            if (count == 0) {
14                /* 3. RECURSION & STRIPPING:
15                   A special string always starts with '1' and ends with '0'.
16                   To optimize it, we leave the outer '1' and '0' alone and 
17                   recursively sort the "inner" part of this block.
18                */
19                String innerPart = s.substring(start + 1, end);
20                results.add("1" + makeLargestSpecial(innerPart) + "0");
21                
22                // Move start pointer to the beginning of the next possible block
23                start = end + 1;
24            }
25        }
26        
27        // 4. GREEDY SORT: 
28        // Since we can swap any two consecutive special substrings, 
29        // we can essentially sort all blocks at this level.
30        Collections.sort(results, Collections.reverseOrder());
31        
32        // 5. JOIN: Combine the sorted blocks to form the largest string
33        return String.join("", results);
34    }
35}