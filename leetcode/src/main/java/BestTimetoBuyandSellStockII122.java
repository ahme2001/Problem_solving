public class BestTimetoBuyandSellStockII122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < prices[i+1])
                profit += (prices[i+1]-prices[i]);
        }
        if (prices[prices.length-1] > prices[prices.length-2])
            profit += (prices[prices.length-1]-prices[prices.length-2]);
        return profit;
    }
}
