class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
