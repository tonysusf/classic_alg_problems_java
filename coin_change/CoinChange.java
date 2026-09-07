import java.util.*;

/*
* javac CoinChange.java; java -ea CoinChange
*/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        System.out.println("input is: " + Arrays.toString(coins) + ", amount is: " + amount);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int coin: coins){
            for(int j=coin; j<=amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }
            // System.out.println("arr: " + Arrays.toString(dp));
        }
        int out = dp[amount]>amount? -1: dp[amount];
        System.out.println("output is: " + out);
        return out;
    }

    public static void main(String[] args) {
        CoinChange s = new CoinChange();

        assert s.coinChange(new int[]{1, 2, 5}, 11) == 3;

        // exact coin amount
        assert s.coinChange(new int[]{2, 5, 10}, 10) == 1;

        // no result
        assert s.coinChange(new int[]{2}, 3) == -1;

        // amount = zero
        assert s.coinChange(new int[]{1, 2, 5}, 0) == 0;

        // one coin
        assert s.coinChange(new int[]{3}, 9) == 3;

        // coin > amount
        assert s.coinChange(new int[]{5, 10}, 3) == -1;

        // combination vs repeat
        assert s.coinChange(new int[]{1, 3, 4}, 6) == 2; // 3 + 3

        // unsorted coins
        assert s.coinChange(new int[]{5, 2, 1}, 7) == 2; // 5 + 2

        // dup coins
        assert s.coinChange(new int[]{1, 2, 2, 5}, 11) == 3;
    }
}

