// Last updated: 12/21/2025, 3:43:44 PM
1class Solution {
2    public String largestTimeFromDigits(int[] arr) {
3
4        HashMap<Integer, Integer> hmap = new HashMap<>();
5        for(int i=0; i<arr.length; i++) {
6            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0)+1);
7        }
8
9        String ans = "";
10        
11        // solve last most digit -- only valid are 2, 1, 0
12        for(int i=2; i>=0 ;i--) {
13            if(hmap.containsKey(i)) {
14                ans = ans + Integer.toString(i);
15                hmap.put(i, hmap.get(i)-1);
16                break;
17            }
18        }
19        if(ans.length() == 0) {
20            return "";
21        }
22
23        // solve second last most digit -- if 1st digit is 2, then 3,2,1,0 are valid
24        //                              -- if 1st digit is 1/0, then all 9 to 0 are valid
25        for(int i=9; i>=0 ;i--) {
26            if(Integer.parseInt(ans) == 2 && i>3) {
27                continue;
28            }
29            if(hmap.containsKey(i) && hmap.get(i) > 0) {
30                ans = ans + Integer.toString(i);
31                hmap.put(i, hmap.get(i)-1);
32                break;
33            }
34        }
35        if(ans.length() < 2) {
36            return "";
37        }
38        ans = ans + ":";
39
40        // solve third last most digit -- only valid are 5,4,3,2,1,0
41        for(int i=5; i>=0 ;i-- ) {
42            if(hmap.containsKey(i) && hmap.get(i) > 0) {
43                ans = ans + Integer.toString(i);
44                hmap.put(i, hmap.get(i)-1);
45                break;
46            }
47        }
48        
49        if(ans.length() < 4) {
50            // both remaining numbers are > 5, so we can see if we can move this number to hours 2nd digit as this have larger range (only if the first digit is 2)
51            // we should also check the 2nd digit of hours is not 2 or 3, because (26-29) and (36-39) are invalid
52            if(ans.charAt(0) == '2' && (ans.charAt(1) == '1' || ans.charAt(1) == '0')) {
53                for(int i=9; i>=6; i--) {
54                    if(hmap.containsKey(i) && hmap.get(i) > 0) {
55                        ans = ans.charAt(1) + Integer.toString(i) + ":" + ans.charAt(0);
56                        hmap.put(i, hmap.get(i)-1);
57                        break;
58                    }
59                }
60            } else
61                return "";
62        }
63
64        // solve fourth last most digit -- all digits are valid
65        for(int i=9; i>=0 ;i-- ) {
66           
67            if(hmap.containsKey(i) && hmap.get(i) > 0) {
68                ans = ans + Integer.toString(i);
69                hmap.put(i, hmap.get(i)-1);
70                break;
71            }
72        }
73        
74        if(ans.length() < 5) {
75            return "";
76        }
77
78        return ans;
79
80
81        
82    }
83}