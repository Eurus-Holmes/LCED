class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){  
            return 0;  
        }  
        int len = prices.length;  
        int maxProfit = 0;  
        int min = prices[0];  
        int arrayA[] = new int[len];  
        
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            arrayA[i]=Math.max(arrayA[i-1],prices[i]-min);
        }
        
        int max = prices[len-1];  
        int arrayB[] = new int[len];  
        for(int i = len-2; i >= 0; i--){
            max = Math.max(prices[i],max);
            arrayB[i] = Math.max(max-prices[i],arrayB[i+1]);
        }  
        
        for(int i = 0; i < len; i++){  
            maxProfit = Math.max(maxProfit,arrayA[i] + arrayB[i]);
        }  
        
        return maxProfit;  
    }
}
