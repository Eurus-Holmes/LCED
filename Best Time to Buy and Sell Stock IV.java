class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k > len) return maxKProfit(prices);
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for(int i=0;i<prices.length-1;i++) {
            int diff = prices[i+1] - prices[i];
            for(int j=k;j>=1;j--) {
                local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j]+diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    public int maxKProfit(int[] prices) {
        int res = 0;
        for(int i=1;i<prices.length;i++) {
            int diff = prices[i] - prices[i-1];
            if(diff>0) res += diff;
        }
        return res;
    }
}
