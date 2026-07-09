// Last updated: 7/9/2026, 5:01:44 PM
import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[][] arr = new long[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = getPos(side, points[i][0], points[i][1]);
            arr[i][1] = points[i][0];
            arr[i][2] = points[i][1];
        }

        Arrays.sort(arr, Comparator.comparingLong(a -> a[0]));

        int low = 0, high = 2 * side, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (can(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(long[][] arr, int k, int dist) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int cnt = 1;
            int prev = start;

            while (cnt < k) {
                int next = nextIndex(arr, prev + 1, arr[prev], dist);
                if (next == -1) break;
                cnt++;
                prev = next;
            }

            if (cnt == k && manhattan(arr[start], arr[prev]) >= dist) {
                return true;
            }
        }
        return false;
    }

    private int nextIndex(long[][] arr, int l, long[] prev, int dist) {
        int r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (manhattan(prev, arr[mid]) >= dist) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private int manhattan(long[] a, long[] b) {
        return (int)(Math.abs(a[1] - b[1]) + Math.abs(a[2] - b[2]));
    }

    private long getPos(int side, int x, int y) {
        if (y == 0) return x;
        if (x == side) return side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }
}