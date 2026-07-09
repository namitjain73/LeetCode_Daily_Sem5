// Last updated: 7/9/2026, 5:19:05 PM
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> st = new HashSet<>();
        
        for (int[] obs : obstacles) {
            st.add(obs[0] + "," + obs[1]);
        }

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int x = 0, y = 0, d = 0, maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) d = (d + 1) % 4;
            else if (cmd == -2) d = (d + 3) % 4;
            else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (st.contains(nx + "," + ny)) break;

                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}