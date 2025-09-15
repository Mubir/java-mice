package mubir.elvnyrexp;

import java.util.Arrays;

public class DpTwoN {

    /**
     * Inner loop in recursion
     */
    void processInner(int i, int j, int[] arr, int[] dp, int n) {
        if (j > i + arr[i] || j >= n) return;

        if (dp[j] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], 1 + dp[j]);
        }

        processInner(i, j + 1, arr, dp, n); // recurse to next j
    }

    void computeDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            processInner(i, i + 1, arr, dp, n);
        }

        System.out.println(dp[0]); // minimum jumps from index 0
    }

    /**
     * ----------------- END -------------------
     */

    /**
     * Outer loop in recursion
     */
    int minJumps(int[] arr, int i, int[] memo) {
        int n = arr.length;

        // Base case: reached the end
        if (i >= n - 1) return 0;

        // If already computed
        if (memo[i] != -1) return memo[i];

        int min = Integer.MAX_VALUE;

        // Try all reachable positions from i
        for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
            int jumps = minJumps(arr, j, memo);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + jumps);
            }
        }

        memo[i] = min;
        return min;
    }


    /**
     * ----------------- END -------------------
     */

    /**
     * both loop in recursion
     */
    void processInnerBoth(int i, int j, int[] arr, int[] dp, int n) {
        if (j > i + arr[i] || j >= n) return;

        if (dp[j] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], 1 + dp[j]);
        }

        processInnerBoth(i, j + 1, arr, dp, n); // recurse to next j
    }

    void computeDPBoth(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            processInnerBoth(i, i + 1, arr, dp, n);
        }

        System.out.println(dp[0]); // minimum jumps from index 0
    }

    /**
     * ----------------- END -------------------
     */

    public static void main(String[] args) {
        int n = 12;
        int arr[] = {2, 3, 4, 5, 1, 3, 4, 5, 2, 4, 5};
        int dp[] = new int[n];

        // bottom up backward.
        /**
         * Example 1: Frog Jump (Min Cost to Reach End)
         * Example 2: Minimum Jumps to Reach End
         * Example 3: Game Theory / Minimax
         *
         * */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < i + arr[i] && j < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
    }
}
