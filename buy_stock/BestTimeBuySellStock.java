import java.util.*;

/*
* javac BestTimeBuySellStock.java; java -ea BestTimeBuySellStock
*/

class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        System.out.println("Input is " + Arrays.toString(prices));

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        System.out.println("Result is " + maxProfit);
        return maxProfit;
    }

    public static void main(String[] argus) {
        BestTimeBuySellStock s = new BestTimeBuySellStock();

        assert s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}) == 5;

        // Prices decreasing
        assert s.maxProfit(new int[] {7, 6, 4, 3, 1}) == 0;

        // Two elements
        assert s.maxProfit(new int[] {1, 5}) == 4;

        // One element
        assert s.maxProfit(new int[] {5}) == 0;

        // Best sell near the end
        assert s.maxProfit(new int[] {3, 2, 6, 1, 8}) == 7;
    }
}

