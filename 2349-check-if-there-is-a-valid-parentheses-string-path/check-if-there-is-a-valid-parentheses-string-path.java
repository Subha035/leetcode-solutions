class Solution {

    private Boolean[][][] dp;
    private int m, n;

    private boolean traverse(char[][] grid, int i, int j, int cnt) {

        if (i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] == '(') {
            cnt++;
        } else {
            cnt--;
        }

        if (cnt < 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return cnt == 0;
        }

        if (dp[i][j][cnt] != null) {
            return dp[i][j][cnt];
        }

        boolean ans = traverse(grid, i + 1, j, cnt) || traverse(grid, i, j + 1, cnt);

        return dp[i][j][cnt] = ans;
    }

    public boolean hasValidPath(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')') {
            return false;
        }

        if (grid[m - 1][n - 1] == '(') {
            return false;
        }

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        dp = new Boolean[m][n][m + n + 1];

        return traverse(grid, 0, 0, 0);
    }
}