// Last updated: 1/5/2026, 12:30:55 AM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int sum = 0;
4        for (int num : nums) {
5            List<Integer> res = new ArrayList<>();
6            for (int j = 1; j * j <= num; j++) {
7                if (num % j == 0) {
8                    res.add(j);
9                    if (j != num / j) { 
10                        res.add(num / j);
11                    }
12                }
13                if (res.size() > 4) break;
14            }
15            if (res.size() == 4) {
16                for (int k : res) {
17                    sum += k;
18                }
19            }
20        }
21        return sum;
22    }
23}