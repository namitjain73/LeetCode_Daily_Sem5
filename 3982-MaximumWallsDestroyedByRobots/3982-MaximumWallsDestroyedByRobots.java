// Last updated: 7/9/2026, 4:59:19 PM
class Solution {
    class Robot {
        int pos;
        int dist;

        Robot(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        Robot[] r_arr = new Robot[n];
        for (int i = 0; i < n; i++) {
            r_arr[i] = new Robot(
                robots[i],
                distance[i]
            );
        }

        Arrays.sort(r_arr, (a, b) -> Integer.compare(a.pos, b.pos));
        Arrays.sort(walls);

        int[] left_count = new int[n], right_count = new int[n], common = new int[n];

        for (int i = 0; i < n; i++) {
            Robot r = r_arr[i];

            int left_start = r.pos - r.dist;
            if (i > 0) {
                left_start = Math.max(left_start, r_arr[i-1].pos + 1);
            }

            int left_end = r.pos;

            int left_idx_start = lower_bound(walls, left_start);
            int left_idx_end = upper_bound(walls, left_end) - 1;

            if (left_idx_start <= left_idx_end) {
                left_count[i] = left_idx_end - left_idx_start + 1;
            } else {
                left_count[i] = 0;
            }

            int right_start = r.pos;
            int right_end = r.pos + r.dist;

            if (i < n-1) {
                right_end = Math.min(right_end, r_arr[i+1].pos - 1);
            }

            int right_idx_start = lower_bound(walls, right_start);
            int right_idx_end = upper_bound(walls, right_end) - 1;

            if (right_idx_start <= right_idx_end) {
                right_count[i] = right_idx_end - right_idx_start + 1;
            } else {
                right_count[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            Robot prev = r_arr[i-1], curr = r_arr[i];

            int prev_right_start = prev.pos;
            int prev_right_end = prev.pos + prev.dist;

            prev_right_end = Math.min(prev_right_end, curr.pos - 1);

            int curr_left_start = curr.pos - curr.dist;
            curr_left_start = Math.max(curr_left_start, prev.pos + 1);
            int curr_left_end = curr.pos;

            int common_start = Math.max(prev_right_start, curr_left_start);
            int common_end = Math.min(prev_right_end, curr_left_end);

            if (common_start <= common_end) {
                int common_idx_start = lower_bound(walls, common_start);
                int common_idx_end = upper_bound(walls, common_end) - 1;
                
                if (common_idx_start <= common_idx_end) {
                    common[i] = common_idx_end - common_idx_start + 1;
                } 
            }
        }

        int[] dp_left = new int[n], dp_right = new int[n];
        dp_left[0] = left_count[0]; dp_right[0] = right_count[0];

        for (int i = 1; i < n; i++) {
            dp_left[i] = left_count[i] + Math.max(dp_left[i-1], dp_right[i-1] - common[i]);

            dp_right[i] = right_count[i] + Math.max(dp_left[i-1], dp_right[i-1]);
        }

        return Math.max(dp_left[n-1], dp_right[n-1]);
    }

    private int lower_bound(int[] walls, int target) {
        int low = 0, high = walls.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (walls[mid] < target){
                low = mid + 1;
            } else high = mid;
        }

        return low;
    }
    
    private int upper_bound(int[] walls, int target) {
        int low = 0, high = walls.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (walls[mid] <= target) {
                low = mid + 1;
            } else high = mid;
        }

        return low;
    }
}