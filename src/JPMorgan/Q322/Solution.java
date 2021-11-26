package JPMorgan.Q322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // Define dp(amount): the fewest number of coins we need to make up AMOUNT
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount, memo);
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin, memo);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}
