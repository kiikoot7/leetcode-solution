import java.util.Arrays;

class Solution {
    private int[][] memo;
    private int[] suffixSum;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n + 1];
        memo = new int[n][n + 1];

        // Calculate suffix sums
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dp(0, 1);
    }

    private int dp(int i, int M) {
        // Base case: take all remaining piles
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int stones = suffixSum[i] - dp(i + X, Math.max(M, X));
            maxStones = Math.max(maxStones, stones);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}