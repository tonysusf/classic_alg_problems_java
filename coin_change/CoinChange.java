import java.util.*;

/*
* javac CoinChange.java; java -ea CoinChange
*/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        System.out.println("Input is: " + Arrays.toString(coins) + ", amount is: " + amount);
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

    public static void main(String[] args){
        assert new CoinChange().coinChange(new int[]{4, 1, 2}, 9) == 3;
    }
}

