class Solution {
    public int totalNQueens(int n) {
        int[] res = {0};
        if(n<=0)
            return res[0];
        int[] columnVal = new int[n];
        DFS_helper(res,n,0,columnVal);
        return res[0];
    }
    public void DFS_helper(int[] res,int nQueens,int row,int[] columnVal){
        if(row == nQueens){
            res[0]++;
        }else{
            for(int i=0;i<nQueens;i++){
                columnVal[row]=i;
                if(isValid(row,columnVal)){
                    DFS_helper(res,nQueens,row+1,columnVal);
                }
            }
        }
    }
    public boolean isValid(int row,int[] columnVal){
        for(int i=0;i<row;i++){
            if(columnVal[row]==columnVal[i] || Math.abs(columnVal[row]-columnVal[i])==row-i)
                return false;
        }
        return true;
    }
}
