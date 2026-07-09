// Last updated: 7/9/2026, 5:01:22 PM
import java.util.*;

class Solution {
    public long sumOfLargestPrimes(String s) {
        Set<Long> p = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j).replaceFirst("^0+", "");
                if (sub.isEmpty()) continue;

                try {
                    long num = Long.parseLong(sub);
                    if (isPrime(num)) {
                        p.add(num);
                    }
                } catch (NumberFormatException e) {}
            }
        }

        List<Long> sp = new ArrayList<>(p);
        sp.sort(Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < Math.min(3, sp.size()); i++) {
            sum += sp.get(i);
        }

        return sum;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
