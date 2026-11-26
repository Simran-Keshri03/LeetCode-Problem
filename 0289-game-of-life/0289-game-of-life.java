class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // First pass: calculate next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;

                // Count live neighbours
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        if (x == 0 && y == 0)
                            continue;

                        int r = i + x;
                        int c = j + y;

                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            live += board[r][c] & 1;
                        }
                    }
                }

                // Current cell is alive
                if ((board[i][j] & 1) == 1) {
                    if (live == 2 || live == 3) {
                        board[i][j] = 3; // Alive -> Alive
                    } else {
                        board[i][j] = 1; // Alive -> Dead
                    }
                }

                // Current cell is dead
                else {
                    if (live == 3) {
                        board[i][j] = 2; // Dead -> Alive
                    }
                }
            }
        }

        // Second pass: update final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}