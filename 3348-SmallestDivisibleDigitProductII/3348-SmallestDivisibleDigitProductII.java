// Last updated: 12/23/2025, 3:36:44 PM
1import java.util.Arrays;
2
3public class Solution {
4    int primes[] = new int[] { 2, 3, 5, 7 };
5    int maxPrime = primes[primes.length - 1];
6
7    public String smallestNumber(String num, long t) {
8        int primeCount[] = new int[maxPrime + 1];
9        int numLength = num.length();
10        int minLength;
11        int firstZeroIndexFromLeft = 0;
12 
13        for (int prime : primes) {
14            while (t % prime == 0) {
15                t /= prime;
16                primeCount[prime]++;
17            }
18        }
19
20        if (t != 1) {
21            return "-1";
22        }
23
24        minLength = getMinLength(primeCount);
25
26
27        if (numLength < minLength) {
28            return buildSuffix(primeCount, minLength, new char[minLength]);
29        }
30
31        char[] result = new char[numLength + 1];
32
33        for (int i = 0; firstZeroIndexFromLeft < numLength
34                && (result[++i] = num.charAt(firstZeroIndexFromLeft)) != '0'; firstZeroIndexFromLeft++) {
35            logNum(primeCount, result[i], -1);
36        }
37
38        if (getMinLength(primeCount) == 0) {
39            if (firstZeroIndexFromLeft == numLength) {
40                return num;
41            }
42            Arrays.fill(result, ++firstZeroIndexFromLeft, result.length, '1');
43            return new String(result, 1, numLength);
44        }
45
46        for (int last = numLength - 1, end = Math.min(firstZeroIndexFromLeft, last); end >= 0; end--) {
47            for (logNum(primeCount, result[end + 1], 1); ++result[end + 1] <= '9'; logNum(primeCount, result[end + 1], 1)) {
48                logNum(primeCount, result[end + 1], -1);
49                if (getMinLength(primeCount) <= last - end) {
50                    return buildSuffix(primeCount, last - end, result);
51                }
52            }
53        }
54
55        return buildSuffix(primeCount, result.length, result);
56    }
57    void logNum(int[] primeCount, int num, int value) {
58        if (num < '2') {
59            return;
60        }
61
62        if (num == '9') {
63            primeCount[3] += value << 1;
64        } else if (num == '4') {
65            primeCount[2] += value << 1;
66        } else if (num == '8') {
67            primeCount[2] += value * 3;
68        } else if (num == '6') {
69            primeCount[2] += value;
70            primeCount[3] += value;
71        } else {
72            primeCount[num - '0'] += value;
73        }
74    }
75    String buildSuffix(int[] primeCount, int targetLength, char[] result) {
76        int index = result.length;
77
78        while (primeCount[3] > 1) {
79            primeCount[3] -= 2;
80            result[--index] = '9';
81        }
82
83        while (primeCount[2] > 2) {
84            primeCount[2] -= 3;
85            result[--index] = '8';
86        }
87
88        while (primeCount[7]-- > 0) {
89            result[--index] = '7';
90        }
91
92        if (primeCount[2] > 0 && primeCount[3] > 0) {
93            result[--index] = '6';
94            primeCount[2]--;
95            primeCount[3]--;
96        }
97
98        while (primeCount[5]-- > 0) {
99            result[--index] = '5';
100        }
101
102        while (primeCount[2] > 1) {
103            primeCount[2] -= 2;
104            result[--index] = '4';
105        }
106
107        while (primeCount[3] > 0) {
108            primeCount[3]--;
109            result[--index] = '3';
110        }
111
112        while (primeCount[2] > 0) {
113            primeCount[2]--;
114            result[--index] = '2';
115        }
116
117        while (index + targetLength != result.length) {
118            result[--index] = '1';
119        }
120
121        return targetLength == result.length ? new String(result) : new String(result, 1, result.length - 1);
122    }
123    int getMinLength(int[] primeCount) {
124        int count2 = Math.max(0, primeCount[2]);
125        int count3 = Math.max(0, primeCount[3]);
126        int count23 = (count3 & 1) + (count2 % 3);
127
128        return (count3 >> 1) + (count2 / 3) + Math.max(0, primeCount[7]) + Math.max(0, primeCount[5])
129                + (count23 == 3 ? 2 : count23 > 0 ? 1 : 0);
130    }
131}