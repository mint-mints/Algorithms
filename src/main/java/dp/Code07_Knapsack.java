package dp;

public class Code07_Knapsack {
    /**
     * 背包问题
     */

    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process(weights, values, bag, 0, 0, 0);
    }

    public static int process(int[] weights, int[] values, int bag, int i, int alreadyWeight, int alreadyValue) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return alreadyValue;
        }

        return Math.max(
                process(weights, values, bag, i + 1, alreadyWeight + weights[i], alreadyValue + values[i]),
                process(weights, values, bag, i + 1, alreadyWeight, alreadyValue));
    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
        System.out.println(maxValue2(weights, values, bag));
    }
}
