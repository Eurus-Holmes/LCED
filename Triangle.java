class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[] dp = new int[triangle.size()];
        
        // initial by last row
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        
        // iterate from last second row
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
