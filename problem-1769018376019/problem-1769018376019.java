// Last updated: 1/21/2026, 11:29:36 PM
1class Solution {
2    public int primeSubarray(int[] nums, int k) {
3        TreeMap<Integer, Integer> map = new TreeMap<>();
4        Deque<Integer> primes = new ArrayDeque<>();
5        int n = nums.length;
6        int ans = 0;
7        int left = 0;
8        for (int right = 0; right < n; right++) {
9            if (isPrime(nums[right])) {
10                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
11                primes.add(right);
12            }
13            while (map.size() > 0 && map.lastKey() - map.firstKey() > k) {
14                if (isPrime(nums[left])) {
15                    int freq = map.get(nums[left]);
16                    freq--;
17                    if (freq == 0)
18                        map.remove(nums[left]);
19                    else
20                        map.put(nums[left], freq);
21                    primes.poll();
22                }
23                left++;
24            }
25            if (primes.size() >= 2) {
26                int firstPos = primes.pollLast();
27                int secondPos = primes.peekLast();
28                ans += secondPos - left + 1;
29                primes.add(firstPos);
30            }
31
32        }
33        return ans;
34    }
35
36    public static boolean isPrime(int n) {
37        if (n <= 1)
38            return false;
39        for (int i = 2; i * i <= n; i++) {
40            if (n % i == 0) {
41                return false;
42            }
43        }
44        return true;
45    }
46}